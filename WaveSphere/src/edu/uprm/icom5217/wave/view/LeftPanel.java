package edu.uprm.icom5217.wave.view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.Box;

public class LeftPanel extends JPanel {
	public LeftPanel() {
		setLayout(null);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(0, 0, 450, 300);
		add(verticalBox);
		
		JScrollPane scrollPane = new JScrollPane();
		verticalBox.add(scrollPane);
		
		JButton btnNewButton = new JButton("New button");
		verticalBox.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		verticalBox.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		verticalBox.add(btnNewButton_2);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  

}
