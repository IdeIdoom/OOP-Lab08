package it.unibo.oop.lab.mvcio;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;


/*
 * This class must implement a simple controller responsible of I/O access. It
 * considers a single file at a time, and it is able to serialize objects in it.
 * 
 * Implement this class with:
 * 
 * 1) A method for setting a File as current file
 * 
 * 2) A method for getting the current File
 * 
 * 3) A method for getting the path (in form of String) of the current File
 * 
 * 4) A method that gets a String as input and saves its content on the current
 * file. This method may throw an IOException.
 * 
 * 5) By default, the current file is "output.txt" inside the user home folder.
 * A String representing the local user home folder can be accessed using
 * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
 * Windows) can be obtained as String through the method
 * System.getProperty("file.separator"). The combined use of those methods leads
 * to a software that runs correctly on every platform.
 */
/**
 * 
 */
public class Controller {

	public final String DEFAULT_PATH = System.getProperty("user.home");
	public final String DEFAULT_FILE = "output.txt";
	public final String SEPARATOR = System.getProperty("file.separator");
	
	private File file = new File(DEFAULT_PATH + SEPARATOR + DEFAULT_FILE);
	
	public File getFile() {
		return this.file;
	}
	
	public String getPath() {
		return this.file.getPath();
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public void printString (String print) throws IOException {
		try(PrintStream ps = new PrintStream(file))
		{
			ps.print(print);
		}
	}
}
