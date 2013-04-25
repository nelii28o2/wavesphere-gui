package edu.uprm.icom5217.wave.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import edu.uprm.icom5217.wave.WaveSphere;
import edu.uprm.icom5217.wave.model.CommPortModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ConnectionPane extends JPanel {
	private static final long serialVersionUID = -8905655347775103530L;
	
	private JLabel pleaseSelectALabel;
	private JComboBox<String> comboBox;
	private JButton connectButton;
	
	public ConnectionPane() {
		setLayout(new MigLayout("", "[c,grow]", "[c][c]"));
		add(getPleaseSelectALabel(), "flowx,cell 0 0");
		add(getComboBox(), "cell 0 0");
		add(getConnectButton(), "cell 0 1,alignx center");
	}

	private JLabel getPleaseSelectALabel() {
		if (pleaseSelectALabel == null) {
			pleaseSelectALabel = new JLabel("Please select a port to connect to this device:");
		}
		return pleaseSelectALabel;
	}
	
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			comboBox.setModel(new CommPortModel());
			//TODO enable button on selection
		}
		return comboBox;
	}
	
	private JButton getConnectButton() {
		if (connectButton == null) {
			connectButton = new JButton("Connect");
			connectButton.addActionListener(new ConnectionController(this));
			connectButton.setName("connectButton");
			if(getComboBox().getItemCount() == 0){
				connectButton.setEnabled(false);
			}
		}
		return connectButton;
	}
	
	private class ConnectionController implements ActionListener{

		private final Component container;

		public ConnectionController(Component container) {
			this.container = container;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				WaveSphere.serial.openSerialPort(
						 comboBox.getSelectedItem().toString(), 9600);
			} catch (Exception e1) {
				JOptionPane//TODO error messages per exception type
						.showMessageDialog(
								container,
								"Error Opening Serial Port: Port is being used by another process...",
								"Error", JOptionPane.ERROR_MESSAGE);
			}

		}

	}
}
