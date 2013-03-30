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
	
	public SphereInfoPanel() {
		setLayout(new MigLayout("", "20[grow,leading]15[grow]20", "[][][]"));
		add(getIdNumberLabel());
		add(getLdNumberValueLabel(), "wrap");
		add(getLastLocationLabel());
		add(getLastLocationValueLabel(), "wrap");
		add(getSamplesLable());
		add(getSpinner(), "wrap");
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
}
