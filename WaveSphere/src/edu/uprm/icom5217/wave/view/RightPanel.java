package edu.uprm.icom5217.wave.view;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JToggleButton;
import javax.swing.JButton;

public class RightPanel extends JPanel {
	private JPanel panel;
	private JToggleButton newToggleButtonToggleButton;
	private JButton removeSphereButton;
	private JButton newButtonButton;
	private JButton enterDiagnosticModeButton;
	public RightPanel() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Sphere 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[41.00][grow][]", "[31.00][101.00,grow][]"));
		add(getNewToggleButtonToggleButton(), "cell 0 0");
		add(getRemoveSphereButton(), "flowx,cell 1 0");
		add(getNewButtonButton(), "cell 2 0");
		add(getPanel(), "flowx,cell 0 1 3 1,growx,aligny top");
		add(getEnterDiagnosticModeButton(), "cell 1 2,alignx center");
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new SphereInfoPanel();
			panel.setName("panel");
		}
		return panel;
	}
	private JToggleButton getNewToggleButtonToggleButton() {
		if (newToggleButtonToggleButton == null) {
			newToggleButtonToggleButton = new JToggleButton("ON/OFF");
			newToggleButtonToggleButton.setName("newToggleButtonToggleButton");
		}
		return newToggleButtonToggleButton;
	}
	private JButton getRemoveSphereButton() {
		if (removeSphereButton == null) {
			removeSphereButton = new JButton("Remove Sphere");
			removeSphereButton.setName("removeSphereButton");
		}
		return removeSphereButton;
	}
	private JButton getNewButtonButton() {
		if (newButtonButton == null) {
			newButtonButton = new JButton("New button");
			newButtonButton.setName("newButtonButton");
		}
		return newButtonButton;
	}
	private JButton getEnterDiagnosticModeButton() {
		if (enterDiagnosticModeButton == null) {
			enterDiagnosticModeButton = new JButton("Enter Diagnostic Mode");
			enterDiagnosticModeButton.setName("enterDiagnosticModeButton");
		}
		return enterDiagnosticModeButton;
	}
}
