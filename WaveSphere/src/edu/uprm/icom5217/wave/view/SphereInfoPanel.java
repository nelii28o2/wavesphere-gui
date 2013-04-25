package edu.uprm.icom5217.wave.view;

import java.awt.Font;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class SphereInfoPanel extends JPanel {
	
	private static final long serialVersionUID = -1992120414454971282L;
	
	private JLabel IdNumberLabel;
	private JLabel ldNumberValueLabel;
	private JLabel lastLocationLabel;
	private JLabel lastLocationValueLabel;
	private JLabel samplesLable;
	private JLabel spaceAvailableLabel;
	private JLabel spaceAvailableValueLabel;
	private JLabel batteryLevelLabel;
	private JLabel batteryLevelValueLabel;
	private JComboBox<String> samplesComboBox;
	
	public SphereInfoPanel() {
		setLayout(new MigLayout("", "[grow][212.00,leading][grow]", "[]10[]10[]10[]10[]"));//TODO fix alignment
		add(getIdNumberLabel(), "flowx,cell 0 0");
		add(getLastLocationLabel(), "flowx,cell 0 1");
		add(getSpaceAvailableLable(), "flowx,cell 0 2");
		add(getBatteryLevelLabel(), "flowx,cell 0 3");
		add(getSamplesLable(), "flowx,cell 0 4");
		add(getLdNumberValueLabel(), "cell 0 0");
		add(getLastLocationValueLabel(), "cell 0 1");
		add(getSpaceAvailableValueLabel(), "cell 0 2");
		add(getBatteryLevelValueLabel(), "cell 0 3");
		add(getComboBox_1(), "cell 0 4");
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
	
	private JLabel getSamplesLable() {
		if (samplesLable == null) {
			samplesLable = new JLabel("Sample:");
			samplesLable.setFont(new Font("Tahoma", Font.BOLD, 11));
			samplesLable.setName("samplesLable");
		}
		return samplesLable;
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
	
	private JComboBox<String> getComboBox_1() {
		if (samplesComboBox == null) {
			samplesComboBox = new JComboBox<String>();
			samplesComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
			samplesComboBox.setName("samplesComboBox");
		}
		return samplesComboBox;
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
	
	public void setSamples(ComboBoxModel<String> model){
		getComboBox_1().setModel(model);
	}
}
