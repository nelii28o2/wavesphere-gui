package edu.uprm.icom5217.wave.xbee;


import edu.uprm.icom5217.wave.utils.SampleFile;
import edu.uprm.icom5217.wave.view.LocationModeWindow;
import edu.uprm.icom5217.wave.view.MainWindow;
import edu.uprm.icom5217.wave.view.RightPanel2;
import edu.uprm.icom5217.wave.view.diagnostic.DiagnosticWindow;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.TooManyListenersException;


public class SerialCommunication implements SerialPortEventListener {

	public Xbee flag;

	private  InputStream inputStream;
	private  PrintStream outputStream;

	private  SerialPort serialPort;

	private StringBuilder sb;

	private int index;
	
	SampleFile f;

	public SerialCommunication() throws IOException{
		sb = new StringBuilder();
		flag = Xbee.STATUS_MODE;
		index = 0;
		f = new SampleFile();
	}	

	public SampleFile getFile(){
		return f;
	}

	public void setFlag(Xbee command) {
		this.flag = command;
	}

	public  void openSerialPort(String port, int baudRate) throws PortInUseException, UnsupportedCommOperationException, TooManyListenersException, IOException {
		openSerialPort(port, "XBee", 0, baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE, SerialPort.FLOWCONTROL_NONE);
	}

	public  void openSerialPort(String port, String appName, int timeout, int baudRate) throws PortInUseException, UnsupportedCommOperationException, TooManyListenersException, IOException {
		openSerialPort(port, appName, timeout, baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE, SerialPort.FLOWCONTROL_NONE);
	}

	@SuppressWarnings("unchecked")
	public  void openSerialPort(String port, String appName, int timeout, int baudRate, int dataBits, int stopBits, int parity, int flowControl) throws PortInUseException, UnsupportedCommOperationException, TooManyListenersException, IOException{
		// Apparently you can't query for a specific port, but instead must iterate
		Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();

		CommPortIdentifier portId = null;

		boolean found = false;

		while (portList.hasMoreElements()) {

			portId = portList.nextElement();

			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				if (portId.getName().equals(port)) {
					//log.debug("Using Port: " + portId.getName());
					found = true;
					break;
				}
			}
		}

		if (!found) {
			System.out.println("Could not find port: " + port);
			throw new NullPointerException();
			//System.exit(1);
		}


		serialPort = (SerialPort) portId.open(appName, timeout);

		serialPort.setSerialPortParams(baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);

		// activate the DATA_AVAILABLE notifier
		serialPort.notifyOnDataAvailable(true);

		// activate the OUTPUT_BUFFER_EMPTY notifier
		//serialPort.notifyOnOutputEmpty(true);

		serialPort.addEventListener(this);

		inputStream = serialPort.getInputStream();
		outputStream = new PrintStream(serialPort.getOutputStream(), true);
	}

	/**
	 * Shuts down RXTX
	 */
	public void close() {
		try {
			serialPort.getInputStream().close();
		} catch (Exception e) {
			System.out.println("Exception while closing input stream");
		}

		try {
			serialPort.getOutputStream().close();
		} catch (Exception e) {
			System.out.println("Exception while closing output stream");
		}

		try {
			// this call blocks while thread is attempting to read from inputstream
			serialPort.close();
		} catch (Exception e) {
			System.out.println("Exception while closing serial port");
		}
	}

	public PrintStream getOutputStream() {
		return outputStream;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void serialEvent(SerialPortEvent event){
		switch (event.getEventType()){
		case SerialPortEvent.DATA_AVAILABLE:
			getDataAvailable(event);
			break;

		default:
			System.out.println("Ignored event: " + event.getEventType());
			break;
		}
	}

	private void getDataAvailable(SerialPortEvent event) {
		try{
			if(this.getInputStream().available() > 0){
				for(int i = 0; i < this.getInputStream().available(); i++){
					char c = (char)this.getInputStream().read();
					//serialWindow.printToTextArea(c);

					switch(flag){
					case STATUS_MODE:
						sb.append(c);
						if(c=='\n'){
							
							String s = sb.toString();
							switch(index){
							case 0:
								RightPanel2.getInstance().setBolaIdLabel(s);
								break;
							case 1:
								RightPanel2.getInstance().setLevelLabel(s);
								break;

							default:
								RightPanel2.getInstance().setMbLabel(s);
								index = 0;
								break;
							}
							sb = new StringBuilder();
						}

						else
							index++;

						break;
					
					case RETRIEVAL_MODE:
						//parsear datos antes de grabar
						f.writeToFile(c);
						if(c == '\n'){//or EOF or something
							f.flush();
							MainWindow.retrievalMode();
						}
						break;
					
					case SAMPLING_MODE:
						sb.append(c);
						if(c=='\n'){
							String s = sb.toString();
							if(s.contains("$GPRMC")){
								//if(!s.contains("V")){
								String[] st = s.split(",");
								s = (st[3].length()>0? (st[3].substring(0, 2) + "\u00B0 " 
										+ st[3].substring(2) + "' ") : "xx\u00B0 mm.dddd' ") + st[4] + ", "
										+ (st[5].length()>0? (st[5].substring(0,3) + "\u00B0 " 
												+ st[5].substring(3) + "' ") : "yyy\u00B0 mm.ddd' ") + st[6] + "\n";

								LocationModeWindow.getInstance().setLabel(s);
							}
							sb = new StringBuilder();
						}

						break;
					
					case DIAGNOSTIC_MODE:
						sb.append(c);
						if(c=='\n'){
							
							String s = sb.toString();

							switch(index){
							case 0:
								DiagnosticWindow.getInstance().setAccelerationValueLabel(s);
								break;
							case 1:
								DiagnosticWindow.getInstance().setGyroValueLabel(s);
								break;
							case 2:
								DiagnosticWindow.getInstance().setMagneticValueLabel(s);
								break;
							case 3:
								DiagnosticWindow.getInstance().setLocationValueLabel(s);
								break;
							case 4:
								DiagnosticWindow.getInstance().setMemoryValueLabel(s);
								break;
							case 5:
								DiagnosticWindow.getInstance().setBatteryValueLabel(s);
								break;
							default:
								DiagnosticWindow.getInstance().setWirelssValueLabel(s);
								index = 0;
							}
							sb = new StringBuilder();

						}

						else
							index++;
						
						break;
					default:
						System.out.println(c);
						break;
					}
				}
			}
		}catch(Exception e){
			System.out.println("Error getting data");
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<String> getSerialPorts(){
		ArrayList<String> serialPorts = new ArrayList<String>();

		Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();

		CommPortIdentifier portId = null;


		while (portList.hasMoreElements()) {

			portId = portList.nextElement();

			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {

				serialPorts.add(portId.getName());

			}
		}

		return serialPorts;
	}

	public void write(Xbee command){
		outputStream.print(command.getCommand());
		//outputStream.print("\r\n"); //needed for AT commands
		outputStream.flush();
	}

	public void write(int data){
		outputStream.write(data);
		outputStream.flush();

	}

	public void write(String s) {
		// TODO Auto-generated method stub
		outputStream.print(s);
		//outputStream.print("\r\n"); //needed for AT commands
		outputStream.flush();
	}

}
