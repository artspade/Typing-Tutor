package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 
 * @author Rowan Meier
 *
 */
public class GuiMenu extends JMenuBar
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1854850886950184331L;
	private JMenu myJmFileItems;
	private JMenu myJmAboutMe;
	
	private JMenuItem myJmiExit;
	
	public GuiMenu()
	{
		instantiateVariables();
		addMenus();
		addMenuItems();
		addActionListeners();
	}
	private void instantiateVariables()
	{
		myJmFileItems = new JMenu("File");
		myJmAboutMe = new JMenu("About..."); //TO-DO
		
		
		myJmiExit = new JMenuItem("Exit");
	}
	private void addMenus()
	{
		this.add(myJmFileItems);
		this.add(myJmAboutMe);
	}
	
	private void addMenuItems()
	{
		myJmFileItems.add(myJmiExit);
	}
	
	private void addActionListeners()
	{
		myJmiExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
	}
}
