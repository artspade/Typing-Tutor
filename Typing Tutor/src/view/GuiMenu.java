package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Rowan Meier
 */
public class GuiMenu extends JMenuBar
{

	/**
	 * Generated serial ID
	 */
	private static final long	serialVersionUID	= 1854850886950184331L;
	/**
	 * the "File" menu
	 */
	private JMenu				myJmFileItems;
	/**
	 * the "About me" menu
	 */
	private JMenu				myJmAboutMe;
	/**
	 * the "Exit" item contained within the "File" menu
	 */
	private JMenuItem			myJmiExit;

	/**
	 * Constructor for the GuiMenu
	 */
	public GuiMenu()
	{
		instantiateVariables();
		addMenus();
		addMenuItems();
		addActionListeners();
	}

	/**
	 * instantiates all variables in this class
	 */
	private void instantiateVariables()
	{
		myJmFileItems = new JMenu("File");
		myJmAboutMe = new JMenu("About..."); // TO-DO

		myJmiExit = new JMenuItem("Exit");
	}

	/**
	 * adds the menus to the menuBar
	 */
	private void addMenus()
	{
		this.add(myJmFileItems);
		this.add(myJmAboutMe);
	}

	/**
	 * adds the menuItems to the menus
	 */
	private void addMenuItems()
	{
		myJmFileItems.add(myJmiExit);
	}

	/**
	 * adds actionListeners to menus and menu items.
	 */
	private void addActionListeners()
	{
		myJmiExit.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);

			}
		});
	}
}
