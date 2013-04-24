package edu.uprm.icom5217.wave.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import edu.uprm.icom5217.wave.WaveSphere;
import edu.uprm.icom5217.wave.view.diagnostic.DiagnosticWindow;
import edu.uprm.icom5217.wave.xbee.XBee;

public class RightPanel2 extends JPanel {
	
	private static final long serialVersionUID = 3495435543444585257L;
	private JLabel idLabel;
	private JButton retrievalModeButton;
	private JButton diagnosticButton;
	private JLabel bolaIdLabel;
	private JButton samplingModeButton;
	private JLabel batterLevelLabel;
	private JLabel levelLabel;
	private JLabel memoryAvailableLabel;
	private JLabel mbLabel;
	private JButton turnOffButton;
	
	public static RightPanel2 instance;
	
	public static RightPanel2 getInstance(){
		if(instance == null)
			instance = new RightPanel2();
		
		return instance;
	}
	
	private RightPanel2() {
		
		setLayout(new MigLayout("fill", "[36.00,grow,center]", "[]5[]5[]5[]5[]5[][]"));
		add(getIdLabel(), "flowx,cell 0 0,alignx center");
		add(getBatterLevelLabel(), "flowx,cell 0 1");
		add(getMemoryAvailableLabel(), "flowx,cell 0 2");
		add(getRetrievalModeButton(), "cell 0 3");
		add(getSamplingModeButton(), "cell 0 4");
		add(getDiagnosticButton(), "cell 0 5");
		add(getBolaIdLabel(), "cell 0 0");
		add(getLevelLabel(), "cell 0 1");
		add(getMbLabel(), "cell 0 2");
		add(getTurnOffButton(), "cell 0 6,alignx right");
	}


	private JLabel getIdLabel() {
		if (idLabel == null) {
			idLabel = new JLabel("ID:   ");
			idLabel.setName("idLabel");
		}
		return idLabel;
	}
	private JButton getRetrievalModeButton() {
		if (retrievalModeButton == null) {
			retrievalModeButton = new JButton("Retrieval Mode");
			retrievalModeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MainWindow.retrievalMode();
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
	private JLabel getBolaIdLabel() {
		if (bolaIdLabel == null) {
			//WaveSphere.serial.write(XBee.lang.ID);
			//WaveSphere.serial.setFlag(XBee.lang.ID);
			//TODO do something to wait for id
			bolaIdLabel = new JLabel("827345980236");
			bolaIdLabel.setName("bolaIdLabel");
		}
		return bolaIdLabel;
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
	private JLabel getBatterLevelLabel() {
		if (batterLevelLabel == null) {
			batterLevelLabel = new JLabel("Battery Level : ");
			batterLevelLabel.setName("batterLevelLabel");
		}
		return batterLevelLabel;
	}
	private JLabel getLevelLabel() {
		if (levelLabel == null) {
			levelLabel = new JLabel("60%");
			levelLabel.setName("label");
		}
		return levelLabel;
	}
	private JLabel getMemoryAvailableLabel() {
		if (memoryAvailableLabel == null) {
			memoryAvailableLabel = new JLabel("Memory Available:  ");
			memoryAvailableLabel.setName("memoryAvailableLabel");
		}
		return memoryAvailableLabel;
	}
	private JLabel getMbLabel() {
		if (mbLabel == null) {
			mbLabel = new JLabel("105MB");
			mbLabel.setName("mbLabel");
		}
		return mbLabel;
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
		bolaIdLabel.setText(s);
	}


	public void setLevelLabel(String s) {
		levelLabel.setText(s);
	}


	public void setMbLabel(String s) {
		mbLabel.setText(s);
	}
	
	
}
