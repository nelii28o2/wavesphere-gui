package edu.uprm.icom5217.wave.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import edu.uprm.icom5217.wave.WaveSphere;
import edu.uprm.icom5217.wave.view.diagnostic.DiagnosticWindow;
import edu.uprm.icom5217.wave.xbee.XBee;

public class RightPanel2 extends JPanel {
	
	private static final long serialVersionUID = 3495435543444585257L;
	private JButton retrievalModeButton;
	private JButton diagnosticButton;
	private JButton samplingModeButton;
	private JButton turnOffButton;
	
	public static RightPanel2 instance;
	private SphereInfoPanel panel;
	
	public static RightPanel2 getInstance(){
		if(instance == null)
			instance = new RightPanel2();
		
		return instance;
	}
	
	private RightPanel2() {
		
		setLayout(new MigLayout("fill", "[36.00,grow,center]", "[147.00,grow]5[]5[]5[][]"));
		add(getPanel(), "cell 0 0,grow");
		add(getRetrievalModeButton(), "cell 0 1");
		add(getSamplingModeButton(), "cell 0 2");
		add(getDiagnosticButton(), "cell 0 3");
		add(getTurnOffButton(), "cell 0 4,alignx right");
	}
	private JButton getRetrievalModeButton() {
		if (retrievalModeButton == null) {
			retrievalModeButton = new JButton("Retrieval Mode");
			retrievalModeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser fc = new JFileChooser();
					fc.showSaveDialog(getInstance());
					//TODO handle the rest.. when the user chooses a file ..etc
					
					
					//TODO file choosing and serial comm should be two different listeners
					WaveSphere.serial.setFlag(XBee.lang.RETRIEVAL_MODE);
					WaveSphere.serial.write(XBee.lang.RETRIEVAL_MODE);
				}
			});
			retrievalModeButton.setName("retrievalModeButton");
		}
		return retrievalModeButton;
	}
	private JButton getDiagnosticButton() {
		if (diagnosticButton == null) {
			diagnosticButton = new JButton("Diagnostic Mode");
			diagnosticButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					WaveSphere.serial.write(XBee.lang.DIAGNOSTIC_MODE);
					WaveSphere.serial.setFlag(XBee.lang.DIAGNOSTIC_MODE);
					DiagnosticWindow.display("");
				}
			});
			diagnosticButton.setName("diagnosticButton");
		}
		return diagnosticButton;
	}
	private JButton getSamplingModeButton() {
		if (samplingModeButton == null) {
			samplingModeButton = new JButton("Sampling Mode");
			samplingModeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					WaveSphere.serial.write(XBee.lang.SAMPLING_MODE);
					WaveSphere.serial.setFlag(XBee.lang.SAMPLING_MODE);
					Calendar c = Calendar.getInstance();
					WaveSphere.serial.write(Long.toString(c.getTimeInMillis()));
					MainWindow.samplingMode();
				}
			});
			samplingModeButton.setName("samplingModeButton");
		}
		return samplingModeButton;
	}
	private JButton getTurnOffButton() {
		if (turnOffButton == null) {
			turnOffButton = new JButton("Shutdown Mode");
			turnOffButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainWindow.connectMode();
				}
			});
			turnOffButton.setName("turnOffButton");
		}
		return turnOffButton;
	}


	public void setBolaIdLabel(String s) {
		getPanel().setIdValue(s);
	}


	public void setLevelLabel(String s) {
		getPanel().setBatteryLevelValue(s);
	}
	
	public void setMbLabel(String s){
		getPanel().setMemoryValue(s);
	}
	
	private SphereInfoPanel getPanel() {
		if (panel == null) {
			panel = new SphereInfoPanel();
		}
		return panel;
	}
}
