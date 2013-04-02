package edu.uprm.icom5217.wave.view;

import java.awt.Dimension;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.Component;

public class LeftPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4124150540994039205L;
	private JPanel scrollListContainer;
	private JList<String> spheresList;

	private JButton addSphereButton;
	private JButton deleteAllButton;
	private JButton downloadAllButton;

	public LeftPanel() {
		setAlignmentY(Component.TOP_ALIGNMENT);
		setMaximumSize(new Dimension(200, 600));
		setLayout(new MigLayout("", "[200px, center]", "[100%][][][][][]"));
		setMinimumSize(new Dimension(200, 50));

		scrollListContainer = new JPanel();
		scrollListContainer.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollListContainer.setBorder(new EmptyBorder(10, 15, 10, 15));
		scrollListContainer.setLayout(new BoxLayout(scrollListContainer,
				BoxLayout.Y_AXIS));

		JScrollPane scrollPane = new JScrollPane(getSpheresList());
		scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Local Spheres:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollListContainer.add(scrollPane);

		add(scrollListContainer, "cell 0 0 1 3, grow, shrink 0");
		add(getAddSphereButton(), "cell 0 3");
		add(getDownloadAllButton(), "cell 0 4");
		add(getDeleteAllButton(), "cell 0 5");
	}

	private JList<String> getSpheresList() {
		if (spheresList == null) {
			spheresList = new JList<String>();
			spheresList.setAlignmentY(Component.TOP_ALIGNMENT);
			spheresList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			spheresList.setModel(new AbstractListModel<String>() {// TODO
																	// extract
																	// model
						/**
				 * 
				 */
						private static final long serialVersionUID = 4832944973241303538L;

						String[] values = new String[] { "Sphere1", "Sphere2",
								"Sphere3", "Sphere4" };

						public int getSize() {
							return values.length;
						}

						public String getElementAt(int index) {
							return values[index];
						}
					});
		}

		return spheresList;
	}

	private JButton getDeleteAllButton() {
		if (deleteAllButton == null) {
			deleteAllButton = new JButton("  Delete All Data  ");
		}

		return deleteAllButton;
	}

	private JButton getDownloadAllButton() {
		if (downloadAllButton == null) {
			downloadAllButton = new JButton("Download All Data");
		}
		return downloadAllButton;
	}

	private JButton getAddSphereButton() {
		if (addSphereButton == null) {
			addSphereButton = new JButton("  Add New Sphere ");
		}

		return addSphereButton;
	}
}
