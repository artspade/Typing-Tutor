package view;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The primary class for representing the GUI. This class is a JFrame.
 * 
 * @author Rowan Meier
 */
public class GUI extends JFrame
{
	/**
	 * Generated serial ID
	 */
	private static final long	serialVersionUID	= 6737679650177968755L;
	/**
	 * Constant used for setting this JFrame's title.
	 */
	private static final String	PROGRAM_TITLE		= "Typing Tutor";
	/**
	 * Constant used for setting this JFrame's width
	 */
	private static final int	FRAME_WIDTH			= 500;
	/**
	 * Constant used for setting this JFrame's height.
	 */
	private static final int	FRAME_HEIGHT		= 500;
	/**
	 * JPanel that will be used to display the text that needs to be typed.
	 */
	private JPanel				myTextPanel;

	private File myTextFile;

	/**
	 * Default constructor for GUI. Instantiates all private objects.
	 */
	public GUI()
	{
		myTextFile = new File(
				"C:\\Users\\rowan\\Desktop\\Eclipse_Java_Workspace\\Typing Tutor\\src\\recources\\words_to_type.txt");
		myTextPanel = new GuiTextPanel(this, myTextFile);
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
	 * Sets up the frame variables.
	 */
	private void setFrameVars()
	{
		this.setVisible(true);
		this.setTitle(PROGRAM_TITLE);
		this.setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(myTextPanel);
	}

}
