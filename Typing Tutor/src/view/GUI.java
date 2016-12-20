package view;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * 
 * @author Rowan Meier
 *
 */
public class GUI extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6737679650177968755L;
	private static int FRAME_WIDTH = 500;
	private static int FRAME_HEIGHT = 500;
	private  String myFrameTitle;
	private JMenuBar myMenuBar; //TO-DO new game, save, load, etc...
	private GuiTextDisplayPanel myPanel;//TO_DO panel to be displayed.
	private String myDisplayText;
	
	/**
	 * Default constructor for GUI. Instantiates all private objects.
	 * myFrameTitle defaults to... "Typing Tutor"
	 */
	public GUI()
	{
		myMenuBar = new GuiMenu();
		this.setJMenuBar(myMenuBar);
		myPanel = new GuiTextDisplayPanel();
		myFrameTitle = "Typing Tutor";
		myDisplayText = "";
	}
	
	/**
	 * Overloaded constructor for GUI. Instantiates all private objects.
	 * Allows the frame title to be changed.
	 */
	public GUI(String theFrameTitle)
	{
		myFrameTitle = theFrameTitle;
		myMenuBar = new GuiMenu();
		this.setJMenuBar(myMenuBar);
		myPanel = new GuiTextDisplayPanel();
		myFrameTitle = "Typing Tutor";
		myDisplayText = "";
	}
	
	/**
	 * fires the GUI to start and become usable.
	 */
	public void start()
	{
		setFrameVars();
		myPanel.setMyDisplayText(getTextFromFile());
		myPanel.repaint();
		this.add(myPanel);
		pack();
	}
	
	/**
	 * Returns the string representation of a file.
	 * @return
	 */
	private String getTextFromFile()//have the file name be an input down the line when you have more tests.
	{
		File fileToDisplay = new File(".\\src\\recources\\Words to type.txt");
		try {
			Scanner input = new Scanner(fileToDisplay);
			while(input.hasNext())
			{
				myDisplayText += input.next() + " ";
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return myDisplayText;
		
	}
	
	/**
	 * Sets up the frame variables.
	 */
	private void setFrameVars()
	{
		this.setVisible(true);
		this.setTitle(myFrameTitle);
		this.setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
