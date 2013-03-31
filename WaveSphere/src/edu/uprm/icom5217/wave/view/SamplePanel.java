package edu.uprm.icom5217.wave.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTable;

public class SamplePanel extends JPanel{
	public SamplePanel() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Sample 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow][grow]", "[][grow][]"));
		add(getSampleStartDateLabel(), "cell 0 0,alignx trailing");
		add(getJanPmLabel(), "cell 1 0");
		add(getTable(), "cell 0 1 2 1,grow");
		add(getDownloadDataButton(), "cell 0 2,alignx center");
		add(getDeleteDataButton(), "cell 1 2,alignx center");
	}

	
	private static final long serialVersionUID = 6642732318340578520L;
	private JLabel sampleStartDateLabel;
	private JLabel janPmLabel;
	private JButton downloadDataButton;
	private JButton deleteDataButton;
	private JTable table;

	
	private JLabel getSampleStartDateLabel() {
		if (sampleStartDateLabel == null) {
			sampleStartDateLabel = new JLabel("Sample Start Date: ");
			sampleStartDateLabel.setName("sampleStartDateLabel");
		}
		return sampleStartDateLabel;
	}
	private JLabel getJanPmLabel() {
		if (janPmLabel == null) {
			janPmLabel = new JLabel("27/Jan/2013 1:00:00 PM");
			janPmLabel.setName("janPmLabel");
		}
		return janPmLabel;
	}
	private JButton getDownloadDataButton() {
		if (downloadDataButton == null) {
			downloadDataButton = new JButton("Download Sample");
			downloadDataButton.setName("downloadDataButton");
		}
		return downloadDataButton;
	}
	private JButton getDeleteDataButton() {
		if (deleteDataButton == null) {
			deleteDataButton = new JButton("Delete Sample");
			deleteDataButton.setName("deleteDataButton");
		}
		return deleteDataButton;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setName("table");
		}
		return table;
	}
}
