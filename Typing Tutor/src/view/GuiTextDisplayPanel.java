package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import model.CharacterLevelStringCompare;

/**
 * 
 * @author Rowan Meier
 *
 */
public class GuiTextDisplayPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -446079737054386501L;
	private static final int CHARACTER_PIXEL_SPACE_HORIZONTAL = 10;
	private static final int CHARACTER_PIXEL_SPACE_VERTICAL = 10;
	private String myDisplayText; // text to be displayed in this JPanel

	public GuiTextDisplayPanel() {
		myDisplayText = ""; 
		setPanelSettings();
	}
	
	private void setPanelSettings()
	{
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		
	}

	/**
	 * paints the string onto the screen.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		displayText(g);
		
		
	}
	
	private void displayText(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		//TO-DO
		int[] comparisonArray = new CharacterLevelStringCompare("String 1",  "String 2").getMyComparisonArray();
		char [] myDisplayTextChars = myDisplayText.toCharArray();
		
		for(int i = 0; i < myDisplayTextChars.length ; i++) //comparisonArray.length
		{
			//int theState = comparisonArray[i];
			int y = ((i * CHARACTER_PIXEL_SPACE_HORIZONTAL + 1000)/ this.getWidth()) * CHARACTER_PIXEL_SPACE_VERTICAL;
			int x = (i * CHARACTER_PIXEL_SPACE_HORIZONTAL) % this.getWidth();
		
			/*switch(theState)
			{
			case -1:
				g2d.setColor(Color.GRAY);
				
				break;
			case 0:
				g2d.setColor(Color.GREEN);
				
				
				break;
			case 1:
				g2d.setColor(Color.RED);
				
				
				break;
				
			}*/
			g2d.drawChars(myDisplayTextChars, i, 1, x, y);
		}
	}

	public void setMyDisplayText(String theDisplayText) {
		myDisplayText = theDisplayText;
		repaint();
	}


	
	
	

}
