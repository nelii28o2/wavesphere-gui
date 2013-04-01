import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.TooManyListenersException;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;


public class serialWindow {
	
	static SerialCommunication serial;
	static String comName;

	private JFrame frame;
	private JComboBox comboBox;
	private JButton btnOpenPort;

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws TooManyListenersException 
	 * @throws UnsupportedCommOperationException 
	 * @throws PortInUseException 
	 */
	public static void main(String[] args) {
		
		serial = new SerialCommunication();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					serialWindow window = new serialWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public serialWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnLed = new JButton("LED1");
		btnLed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serial.write(XBee.lang.LED1);
			}
		});
		
		JButton btnLed_1 = new JButton("LED2");
		btnLed_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serial.write(XBee.lang.LED2);
			}
		});
		
		btnOpenPort = new JButton("OPEN PORT");
		btnOpenPort.addActionListener(new ActionListener() {
			private boolean portOpen;

			public void actionPerformed(ActionEvent e) {
				try {
					if(!portOpen){
						serial.openSerialPort((String) comboBox.getSelectedItem(), 9600);
						btnOpenPort.setText("CLOSE PORT");
						comboBox.setEnabled(false);
						portOpen = true;
					} else {
						serial.close();
						btnOpenPort.setText("OPEN PORT");
						comboBox.setEnabled(true);
						portOpen = false;
					}
				} catch (PortInUseException e1) {
					new msgDialog("Error Opening Serial Port:\nPort is being used by another process...");
					e1.printStackTrace();
				} catch (UnsupportedCommOperationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (TooManyListenersException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		comboBox = new JComboBox(serial.getSerialPorts().toArray());
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLed)
						.addComponent(btnLed_1))
					.addPreferredGap(ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnOpenPort, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLed)
						.addComponent(btnOpenPort))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLed_1)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(198, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
