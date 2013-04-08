package edu.uprm.icom5217.wave.view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class RightPanel2 extends JPanel {
	private JLabel idLabel;
	private JButton newButtonButton;
	private JButton newButtonButton_1;
	private JButton newButtonButton_2;
	private JLabel bolaIdLabel;
	public RightPanel2() {
		setLayout(new MigLayout("", "15[36.00,grow,c][grow, c]15", "15[grow, c]5[grow,c]5[grow,c]5[grow,c]15"));
		add(getIdLabel(), "cell 0 0,alignx center");
		add(getBolaIdLabel(), "cell 1 0");
		add(getNewButtonButton(), "cell 0 1 2 1");
		add(getNewButtonButton_1(), "cell 0 2 2 1");
		add(getNewButtonButton_2(), "cell 0 3 2 1");
	}


	private JLabel getIdLabel() {
		if (idLabel == null) {
			idLabel = new JLabel("id: ");
			idLabel.setName("idLabel");
		}
		return idLabel;
	}
	private JButton getNewButtonButton() {
		if (newButtonButton == null) {
			newButtonButton = new JButton("Retrieval Mode");
			newButtonButton.setName("newButtonButton");
		}
		return newButtonButton;
	}
	private JButton getNewButtonButton_1() {
		if (newButtonButton_1 == null) {
			newButtonButton_1 = new JButton("Location Mode");
			newButtonButton_1.setName("newButtonButton_1");
		}
		return newButtonButton_1;
	}
	private JButton getNewButtonButton_2() {
		if (newButtonButton_2 == null) {
			newButtonButton_2 = new JButton("Diagnostic Mode");
			newButtonButton_2.setName("newButtonButton_2");
		}
		return newButtonButton_2;
	}
	private JLabel getBolaIdLabel() {
		if (bolaIdLabel == null) {
			bolaIdLabel = new JLabel("bola id");
			bolaIdLabel.setName("bolaIdLabel");
		}
		return bolaIdLabel;
	}
}
