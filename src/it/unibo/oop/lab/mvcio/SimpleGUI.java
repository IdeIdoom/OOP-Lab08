package it.unibo.oop.lab.mvcio;

import java.awt.*;
import java.awt.event.*;  
import java.io.IOException;

import javax.swing.*;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("Simple GUI with Controller");
    
    private Controller controller = new Controller();

    /*
     * Once the Controller is done, implement this class in such a way that:
     * 
     * 1) It has a main method that starts the graphical application
     * 
     * 2) In its constructor, sets up the whole view
     * 
     * 3) The graphical interface consists of a JTextArea with a button "Save" right
     * below (see "ex02.png" for the expected result). SUGGESTION: Use a JPanel with
     * BorderLayout
     * 
     * 4) By default, if the graphical interface is closed the program must exit
     * (call setDefaultCloseOperation)
     * 
     * 5) The program asks the controller to save the file if the button "Save" gets
     * pressed.
     * 
     * Use "ex02.png" (in the res directory) to verify the expected aspect.
     */

    /**
     * builds a new {@link SimpleGUI}.
     */
    public SimpleGUI() {
        /*
         * Make the frame half the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected.
         * 
         * In order to deal coherently with multimonitor setups, other
         * facilities exist (see the Java documentation about this issue). It is
         * MUCH better than manually specify the size of a window in pixel: it
         * takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JPanel panel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("Save");
        save.addActionListener(ev1 -> {
        		try{
        			writeToFile(textArea.getText());
        		}
        		catch(IOException error) {
        			JOptionPane.showMessageDialog(null, error.getMessage(), "An error occurred", JOptionPane.ERROR_MESSAGE);
        		}
        });
        final LayoutManager lm = new BorderLayout();
        
        panel.setLayout(lm);
        
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);
        
        frame.getContentPane().add(panel);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
    }
    
	private void checkIfFileExists() {
		if (!controller.getFile().getParentFile().exists())
			throw new IllegalArgumentException("File does not exist");
	}
	
    private void writeToFile(final String text) throws IOException {
    	try {
    		checkIfFileExists();
    	}
    	catch(Exception error)
    	{
    		throw error;
    	}
		controller.printString(text);
	}

	public void show() {
    	frame.setVisible(true);
    }
    
    public static void main(final String... a) {
        final SimpleGUI gui = new SimpleGUI();
        gui.show();
        
    }
    
}


