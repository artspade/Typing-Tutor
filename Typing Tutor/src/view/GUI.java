package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

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
	private JPanel myPanel;//TO_DO panel to be displayed.
	
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
	}
	
	/**
	 * Overloaded constructor for GUI. Instantiates all private objects.
	 * Allows the frame title to be changed.
	 */
	public GUI(String theFrameTitle)
	{
		myFrameTitle = theFrameTitle;
	}
	
	/**
	 * fires the GUI to start and become usable.
	 */
	public void start()
	{
		setFrameVars();
		this.add(myPanel);
	}
	
	/**
	 * Sets up the frame variables.
	 */
	private void setFrameVars()
	{
		this.setVisible(true);
		this.setTitle(myFrameTitle);
		this.setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
	}
	
	
}
