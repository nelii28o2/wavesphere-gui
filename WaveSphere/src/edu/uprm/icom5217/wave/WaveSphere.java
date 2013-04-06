package edu.uprm.icom5217.wave;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.uprm.icom5217.wave.view.MainWindow;


public class WaveSphere{

	private static  MainWindow window;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			System.out.println(UIManager.getLookAndFeel());
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//might make it look better on Mac
			System.out.println(UIManager.getLookAndFeel());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			System.out.println("Could not apply local look and feel. Using default.");
		}
		
		window =  new MainWindow();
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				window.pack();
				window.setVisible(true);
				window.setMinimumSize(window.getSize());
				window.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			}
		});
	
	}
	
}
