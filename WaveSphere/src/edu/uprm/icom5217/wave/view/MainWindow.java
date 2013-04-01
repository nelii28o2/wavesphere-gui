package edu.uprm.icom5217.wave.view;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import net.miginfocom.swing.MigLayout;

public class MainWindow extends JFrame{
	
	/**
	 * The generated serial ID
	 */
	private static final long serialVersionUID = 6647353545887103818L;
	private JSplitPane splitPane;
	
	public MainWindow() {
		getContentPane().setLayout(new MigLayout("fill", "", ""));
		getContentPane().add(getSplitPane(), "cell 0 0,grow,aligny top");
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setEnabled(false);
			splitPane.setAutoscrolls(true);
			splitPane.setName("splitPane");
			splitPane.setLeftComponent(new LeftPanel());
			splitPane.setRightComponent(new RightPanel());
		}
		return splitPane;
	}
}
