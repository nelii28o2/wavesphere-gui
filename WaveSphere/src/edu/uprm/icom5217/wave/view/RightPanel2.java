package edu.uprm.icom5217.wave.view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

import edu.uprm.icom5217.wave.view.diagnostic.DiagnosticWindow;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RightPanel2 extends JPanel {
	private JLabel idLabel;
	private JButton retrievalModeButton;
	private JButton diagnosticButton;
	private JLabel bolaIdLabel;
	public RightPanel2() {
		setLayout(new MigLayout("", "15[36.00,grow,c][grow, c]15", "15[grow, c]5[grow,c]5[grow,c]5[grow,c]15"));
		add(getIdLabel(), "cell 0 0,alignx center");
		add(getBolaIdLabel(), "cell 1 0");
		add(getRetrievalModeButton(), "cell 0 1 2 1");
		add(getDiagnosticButton(), "cell 0 3 2 1");
	}


	private JLabel getIdLabel() {
		if (idLabel == null) {
			idLabel = new JLabel("id: ");
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
				   DiagnosticWindow.display("");
				}
			});
			diagnosticButton.setName("diagnosticButton");
		}
		return diagnosticButton;
	}
	private JLabel getBolaIdLabel() {
		if (bolaIdLabel == null) {
			bolaIdLabel = new JLabel("827345980236");
			bolaIdLabel.setName("bolaIdLabel");
		}
		return bolaIdLabel;
	}
}
