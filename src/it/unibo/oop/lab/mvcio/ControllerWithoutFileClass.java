package it.unibo.oop.lab.mvcio;
import java.io.*;
import java.util.Optional;

/**
 * 
 */
public class ControllerWithoutFileClass {

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
	
	//Default stuff, separator will be of big help
	public final String DEFAULT_PATH = System.getProperty("user.home");
	public final String DEFAULT_FILE = "output.txt";
	public final String SEPARATOR = System.getProperty("separator");
	
	private String path = DEFAULT_PATH;
	private String filename = DEFAULT_FILE;
	
	public ControllerWithoutFileClass(String path, Optional<String> filename) {
		//Just in case it's an actual filename, need check for folder or not
		this.path = path;
		this.filename = filename.isPresent() ? filename.get() : DEFAULT_FILE;
	}
	
	public void setFile(String path) {
		/*
		 * Warning
		 * Watch out if it's a folder or not; should be fine in the dialog box tho
		 */
		String[] pathToFile = path.split(SEPARATOR);
		this.filename = pathToFile[pathToFile.length-1];
		String newPath = "";
		for (int i = 0; i < pathToFile.length-1; i++)
		{
			newPath.concat(pathToFile[i]);
			newPath.concat(SEPARATOR);
		}
		this.path = newPath;
	}
	
	
	

}
