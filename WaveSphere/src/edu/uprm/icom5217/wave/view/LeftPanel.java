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

public class LeftPanel extends JPanel {
	public LeftPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.PAGE_AXIS));
	
		JList<String> spheresList = new JList<String>();
		spheresList.setBackground(Color.WHITE);
		spheresList.setPreferredSize(new Dimension(50, 200));
		spheresList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		spheresList.setOpaque(false);
		spheresList.setModel(new AbstractListModel<String>() {
			
			private static final long serialVersionUID = 8041856790125168772L;
			String[] values = new String[] {"Sphere1", "Sphere2"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		spheresList.setMinimumSize(new Dimension(50, 400));
		
		
		scrollPane = new JScrollPane(spheresList);
		scrollPane.setBorder(new TitledBorder(null, "Wave Spheres:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(scrollPane);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setMinimumSize(new Dimension(40, 80));
		scrollPane.setPreferredSize(new Dimension(50, 65));
		
		
		btnNewButton = new JButton("Add New Sphere");
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Download All Data");
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete All Data");
		add(btnNewButton_2);
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
  

}
