package edu.uprm.icom5217.wave.view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class SphereInfoPanel extends JPanel {
	
	private static final long serialVersionUID = -1992120414454971282L;
	
	private JLabel IdNumberLabel;
	private JLabel ldNumberValueLabel;
	private JLabel lastLocationLabel;
	private JLabel lastLocationValueLabel;
	private JLabel spaceAvailableLabel;
	private JLabel spaceAvailableValueLabel;
	private JLabel batteryLevelLabel;
	private JLabel batteryLevelValueLabel;
	
	public SphereInfoPanel() {
		setLayout(new MigLayout("", "[grow][][grow]", "[]10[]10[]10[]"));
		add(getIdNumberLabel(), "flowx,cell 1 0");
		add(getLastLocationLabel(), "flowx,cell 1 1");
		add(getSpaceAvailableLable(), "flowx,cell 1 2");
		add(getBatteryLevelLabel(), "flowx,cell 1 3");
		add(getLdNumberValueLabel(), "cell 1 0");
		add(getLastLocationValueLabel(), "cell 1 1");
		add(getSpaceAvailableValueLabel(), "cell 1 2");
		add(getBatteryLevelValueLabel(), "cell 1 3");
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
			lastLocationValueLabel = new JLabel("5\u00B0 20' 36.2394\", 5\u00B0 20' 43.8\"");
			lastLocationValueLabel.setName("lastLocationValueLabel");
		}
		return lastLocationValueLabel;
	}
	
	private JLabel getSpaceAvailableLable(){
		if(spaceAvailableLabel ==null){
			spaceAvailableLabel = new JLabel("Memory Available:");
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
	
	public void setIdValue(String value){
		getIdNumberLabel().setText(value);
	}
	
	public void setLocationValue(String value){
		getLastLocationValueLabel().setText(value);
	}
	
	public void setMemoryValue(String value){
		getSpaceAvailableValueLabel().setText(value);
	}
	
	public void setBatteryLevelValue(String value){
		getBatteryLevelValueLabel().setText(value);
	}
}
