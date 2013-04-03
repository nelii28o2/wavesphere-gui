package edu.uprm.icom5217.wave.view.diagnostic;

import javax.swing.JDialog;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

public class DiagnosticWindow extends JDialog {
	private JLabel batteryStatusLabel;
	private JLabel memoryLabel;
	private JLabel locationLabel;
	private JLabel wirelessLabel;
	private JLabel newLabelLabel;
	private JLabel angleLabel;
	private JLabel magenticLabel;
	
	public DiagnosticWindow() {
		setTitle("Diagnosis Of Sphere 1");
		getContentPane().setLayout(new MigLayout("", "20[fill]20[fill]20", "[][][][][][][]"));
		getContentPane().add(getBatteryStatusLabel(), "cell 0 0");
		getContentPane().add(getMemoryLabel(), "cell 0 1");
		getContentPane().add(getLocationLabel(), "cell 0 2");
		getContentPane().add(getWirelessLabel(), "cell 0 3");
		getContentPane().add(getNewLabelLabel(), "cell 0 4");
		getContentPane().add(getAngleLabel(), "cell 0 5");
		getContentPane().add(getMagenticLabel(), "cell 0 6");
	}
	private JLabel getBatteryStatusLabel() {
		if (batteryStatusLabel == null) {
			batteryStatusLabel = new JLabel("Battery:");
			batteryStatusLabel.setName("batteryStatusLabel");
		}
		return batteryStatusLabel;
	}
	private JLabel getMemoryLabel() {
		if (memoryLabel == null) {
			memoryLabel = new JLabel("Memory:");
			memoryLabel.setName("memoryLabel");
		}
		return memoryLabel;
	}
	private JLabel getLocationLabel() {
		if (locationLabel == null) {
			locationLabel = new JLabel("Location:");
			locationLabel.setName("locationLabel");
		}
		return locationLabel;
	}
	private JLabel getWirelessLabel() {
		if (wirelessLabel == null) {
			wirelessLabel = new JLabel("Wireless:");
			wirelessLabel.setName("wirelessLabel");
		}
		return wirelessLabel;
	}
	private JLabel getNewLabelLabel() {
		if (newLabelLabel == null) {
			newLabelLabel = new JLabel("Acceleration:");
			newLabelLabel.setName("newLabelLabel");
		}
		return newLabelLabel;
	}
	private JLabel getAngleLabel() {
		if (angleLabel == null) {
			angleLabel = new JLabel("Angle:");
			angleLabel.setName("angleLabel");
		}
		return angleLabel;
	}
	private JLabel getMagenticLabel() {
		if (magenticLabel == null) {
			magenticLabel = new JLabel("Magentic:");
			magenticLabel.setName("magenticLabel");
		}
		return magenticLabel;
	}
}
