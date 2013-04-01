package edu.uprm.icom5217.wave;

import java.awt.EventQueue;

import edu.uprm.icom5217.wave.view.MainWindow;


public class WaveSphere{

	private static final MainWindow window = new MainWindow();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				window.pack();
				window.setVisible(true);
				
			}
		});
	
	}
	
}
