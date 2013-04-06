package edu.uprm.icom5217.wave.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import edu.uprm.icom5217.wave.view.diagnostic.DiagnosticWindow;

import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RightPanel extends JPanel {
	private JPanel sphereInfoPanel;
	private JToggleButton newToggleButtonToggleButton;
	private JButton refreshButton;
	private JButton enterDiagnosticModeButton;
	private JButton sampleConfigurationButton;
	public RightPanel() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Sphere 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[41.00][grow][]", "[31.00][101.00,grow][][grow]"));
		add(getNewToggleButtonToggleButton(), "cell 0 0");
		add(getEnterDiagnosticModeButton(), "cell 1 0,alignx center");
		add(getRefreshButton(), "cell 2 0");
		add(getSphereInfoPanel(), "flowx,cell 0 1 3 1,growx,aligny top");
		add(getSampleConfigurationButton(), "cell 1 2,alignx center");
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
	private JButton getRefreshButton() {
		if (refreshButton == null) {
			refreshButton = new JButton("Refresh");
			refreshButton.setName("refreshButton");
		}
		return refreshButton;
	}
	private JButton getEnterDiagnosticModeButton() {
		if (enterDiagnosticModeButton == null) {
			enterDiagnosticModeButton = new JButton("Enter Diagnostic Mode");
			enterDiagnosticModeButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					DiagnosticWindow.display("");
				}
			});
			enterDiagnosticModeButton.setName("enterDiagnosticModeButton");
		}
		return enterDiagnosticModeButton;
	}
	private JButton getSampleConfigurationButton() {
		if (sampleConfigurationButton == null) {
			sampleConfigurationButton = new JButton("Manage Samples");
			sampleConfigurationButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			sampleConfigurationButton.setName("sampleConfigurationButton");
		}
		return sampleConfigurationButton;
	}
}
