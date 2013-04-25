package edu.uprm.icom5217.wave.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import edu.uprm.icom5217.wave.view.MainWindow;

public class SampleFile {

	private File file;
	private FileWriter fw;

	public SampleFile() throws IOException {
		file = File.createTempFile("samples", ".txt");
		fw = new FileWriter(file);
	}
	
	public void writeToFile(char c) throws IOException{
		fw.append(c);
	}
	
	public void flush() throws IOException{
		fw.flush();
		fw.close();
	}
}
