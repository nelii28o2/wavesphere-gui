package edu.uprm.icom5217.wave;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.uprm.icom5217.wave.view.MainWindow;


public class WaveSphere{

	private static final MainWindow window = new MainWindow();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//might make it look better on Mac
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			//failed, then just use default Java one.
		}
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				window.pack();
				window.setVisible(true);
				window.setMinimumSize(window.getSize());
			}
		});
	
	}
	
}
