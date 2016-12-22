package view;

import java.awt.Dimension;

import javax.swing.JFrame;

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
	private static final String PROGRAM_TITLE = "Typing Tutor";
	private static int FRAME_WIDTH = 500;
	private static int FRAME_HEIGHT = 500;
	private  String myFrameTitle;
	//private JMenuBar myMenuBar; //TO-DO new game, save, load, etc...
	
	/**
	 * Default constructor for GUI. Instantiates all private objects.
	 * myFrameTitle defaults to... "Typing Tutor"
	 */
	public GUI()
	{
		//myMenuBar = new GuiMenu();
		//this.setJMenuBar(myMenuBar);
		myFrameTitle = PROGRAM_TITLE;
	}

	/**
	 * fires the GUI to start and become usable.
	 */
	public void start()
	{
		setFrameVars();
		pack();
	}
	
	/**
	 * Returns the string representation of a file.
	 * @return
	 */
	
	
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
