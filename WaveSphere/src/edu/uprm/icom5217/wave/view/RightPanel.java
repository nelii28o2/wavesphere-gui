package edu.uprm.icom5217.wave.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.Component;

public class RightPanel extends JPanel {
	private JPanel sphereInfoPanel;
	private JToggleButton newToggleButtonToggleButton;
	private JButton newButtonButton;
	private JButton enterDiagnosticModeButton;
	private JPanel samplePanel;
	private JButton configureSampleButton;
	public RightPanel() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Sphere 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[41.00][grow][]", "[31.00][101.00,grow][][grow]"));
		add(getNewToggleButtonToggleButton(), "cell 0 0");
		add(getEnterDiagnosticModeButton(), "cell 1 0,alignx center");
		add(getNewButtonButton(), "cell 2 0");
		add(getSphereInfoPanel(), "flowx,cell 0 1 3 1,growx,aligny top");
		add(getConfigureSampleButton(), "cell 1 2,alignx center");
		add(getPanel_1(), "cell 1 3,grow");
	}
	private JPanel getSphereInfoPanel() {
		if (sphereInfoPanel == null) {
			sphereInfoPanel = new SphereInfoPanel();
			sphereInfoPanel.setName("sphereInfoPanel");
		}
		return sphereInfoPanel;
	}
	private JToggleButton getNewToggleButtonToggleButton() {
		if (newToggleButtonToggleButton == null) {
			newToggleButtonToggleButton = new JToggleButton("ON/OFF");
			newToggleButtonToggleButton.setName("newToggleButtonToggleButton");
		}
		return newToggleButtonToggleButton;
	}
	private JButton getNewButtonButton() {
		if (newButtonButton == null) {
			newButtonButton = new JButton("Update Info");
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
	private JPanel getPanel_1() {
		if (samplePanel == null) {
			samplePanel = new SamplePanel();
			samplePanel.setName("panel_1");
		}
		return samplePanel;
	}
	private JButton getConfigureSampleButton() {
		if (configureSampleButton == null) {
			configureSampleButton = new JButton("Configure New Sample");
			configureSampleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			configureSampleButton.setName("configureSampleButton");
		}
		return configureSampleButton;
	}
}
