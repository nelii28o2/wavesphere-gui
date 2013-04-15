package edu.uprm.icom5217.wave.view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.ComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.event.ListDataListener;
import javax.swing.DefaultComboBoxModel;

import edu.uprm.icom5217.wave.model.CommPortModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConnectionPane extends JPanel {
	private JLabel pleaseSelectALabel;
	private JComboBox comboBox;
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
			pleaseSelectALabel.setName("pleaseSelectALabel");
		}
		return pleaseSelectALabel;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new CommPortModel());
			comboBox.setName("comboBox");
		}
		return comboBox;
	}
	private JButton getConnectButton() {
		if (connectButton == null) {
			connectButton = new JButton("Connect");
			connectButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				  MainWindow.normalMode();
				}
			});
			connectButton.setName("connectButton");
		}
		return connectButton;
	}
}
