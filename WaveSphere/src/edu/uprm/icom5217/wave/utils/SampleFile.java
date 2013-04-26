package edu.uprm.icom5217.wave.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SampleFile {

	private File file;
	private FileWriter fw;

	public SampleFile(File file) throws IOException {
		this.file = file;
		fw = new FileWriter(file);
	}
	
	public void writeToFile(char c) throws IOException{
		fw.append(c);
	}
	
	public File getTemp(){
		return file;
	}
	
	public void flush() throws IOException{
		fw.flush();
		fw.close();
	}
}
