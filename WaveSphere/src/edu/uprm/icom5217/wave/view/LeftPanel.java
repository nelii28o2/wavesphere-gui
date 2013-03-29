package edu.uprm.icom5217.wave.view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.Insets;
import javax.swing.JList;
import java.awt.Dimension;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.UIManager;

public class LeftPanel extends JPanel {
	public LeftPanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.PAGE_AXIS));
		
			JList<String> spheresList = new JList<String>();
			spheresList.setBackground(Color.WHITE);
			spheresList.setPreferredSize(new Dimension(30, 100));
			spheresList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			spheresList.setOpaque(false);
			spheresList.setModel(new AbstractListModel() {
				String[] values = new String[] {"Sphere1", "Sphere2", "Sphere3", "Sphere4"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			
			scrollPane = new JScrollPane(spheresList);
			scrollPane.setPreferredSize(new Dimension(50, 100));
			scrollPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Local Spheres:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.add(scrollPane);
			scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
			scrollPane.setMinimumSize(new Dimension(50, 100));
		
		panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel = new JPanel();
		panel_2.add(panel);
		
		
		btnNewButton = new JButton("Add New Sphere");
		panel.add(btnNewButton);
		
		panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		btnNewButton_1 = new JButton("Download All Data");
		panel_3.add(btnNewButton_1);
		
		panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		btnNewButton_2 = new JButton("Delete All Data");
		panel_4.add(btnNewButton_2);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
  

}
