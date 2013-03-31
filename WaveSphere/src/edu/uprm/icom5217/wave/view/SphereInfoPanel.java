package edu.uprm.icom5217.wave.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import net.miginfocom.swing.MigLayout;

public class SphereInfoPanel extends JPanel {
	
	private static final long serialVersionUID = -1992120414454971282L;
	private JLabel IdNumberLabel;
	private JLabel ldNumberValueLabel;
	private JLabel lastLocationLabel;
	private JLabel lastLocationValueLabel;
	private JLabel samplesLable;
	private JSpinner spinner;
	private JLabel spaceAvailableLabel;
	private JLabel spaceAvailableValueLabel;
	private JLabel batteryLevelLabel;
	private JLabel batteryLevelValueLabel;
	
	public SphereInfoPanel() {
		setLayout(new MigLayout("", "[grow,leading]15[grow]", "[][][][][]"));
		add(getIdNumberLabel(), "cell 0 0");
		add(getLdNumberValueLabel(), "cell 1 0");
		add(getLastLocationLabel(), "cell 0 1");
		add(getLastLocationValueLabel(), "cell 1 1");
		add(getSpaceAvailableLable(), "cell 0 2");
		add(getSpaceAvailableValueLabel(), "cell 1 2");
		add(getBatteryLevelLabel(), "cell 0 3");
		add(getBatteryLevelValueLabel(), "cell 1 3");
		add(getSamplesLable(), "cell 0 4");
		add(getSpinner(), "cell 1 4");
	}

	

	private JLabel getIdNumberLabel() {
		if (IdNumberLabel == null) {
			IdNumberLabel = new JLabel("ID Number: ");
			IdNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			IdNumberLabel.setName("IdNumberLabel");
		}
		return IdNumberLabel;
	}
	private JLabel getLdNumberValueLabel() {
		if (ldNumberValueLabel == null) {
			ldNumberValueLabel = new JLabel("097434134");
			ldNumberValueLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
			ldNumberValueLabel.setName("ldNumberValueLabel");
		}
		return ldNumberValueLabel;
	}
	private JLabel getLastLocationLabel() {
		if (lastLocationLabel == null) {
			lastLocationLabel = new JLabel("Last Location:");
			lastLocationLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lastLocationLabel.setName("lastLocationLabel");
		}
		return lastLocationLabel;
	}
	private JLabel getLastLocationValueLabel() {
		if (lastLocationValueLabel == null) {
			lastLocationValueLabel = new JLabel("1234 N42134S");
			lastLocationValueLabel.setForeground(Color.BLUE);
			lastLocationValueLabel.setName("lastLocationValueLabel");
		}
		return lastLocationValueLabel;
	}
	private JLabel getSamplesLable() {
		if (samplesLable == null) {
			samplesLable = new JLabel("Sample:");
			samplesLable.setFont(new Font("Tahoma", Font.BOLD, 11));
			samplesLable.setName("samplesLable");
		}
		return samplesLable;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
		}
		return spinner;
	}
	
	private JLabel getSpaceAvailableLable(){
		if(spaceAvailableLabel ==null){
			spaceAvailableLabel = new JLabel("Memory Available: ");
			spaceAvailableLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		
		return spaceAvailableLabel;
	}
	private JLabel getSpaceAvailableValueLabel() {
		if (spaceAvailableValueLabel == null) {
			spaceAvailableValueLabel = new JLabel("40MB (10%)");
			spaceAvailableValueLabel.setName("spaceAvailableValueLabel");
		}
		return spaceAvailableValueLabel;
	}
	private JLabel getBatteryLevelLabel() {
		if (batteryLevelLabel == null) {
			batteryLevelLabel = new JLabel("Battery Level:");
			batteryLevelLabel.setName("batteryLevelLabel");
			batteryLevelLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		return batteryLevelLabel;
	}
	private JLabel getBatteryLevelValueLabel() {
		if (batteryLevelValueLabel == null) {
			batteryLevelValueLabel = new JLabel("20%");
			batteryLevelValueLabel.setName("batteryLevelValueLabel");
		}
		return batteryLevelValueLabel;
	}
}
