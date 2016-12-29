package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.ComparisonGrid;

/**
 * This class is used for displaying text to type using paintComponent
 * 
 * @author Rowan Meier
 */
public class GuiTextPanel extends JPanel implements Observer
{

	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -1421873357843121287L;

	/**
	 * The string that we are trying to match against .
	 */
	private String			myTargetString;
	/**
	 * ComparisonGrid used to determine the correct format for each character
	 * displayed to the screen.
	 */
	private ComparisonGrid	myComparisonGrid;

	/**
	 * Constructor for the GuiTextPanel
	 * 
	 * @param theFrame
	 *            The JFrame that this class will be displayed on
	 * @param theFile
	 *            The text file that will be displayed using the paintComponent
	 *            method
	 */
	public GuiTextPanel(JFrame theFrame, File theFile)
	{
		myTargetString = getFileText(theFile);
		myComparisonGrid = new ComparisonGrid(myTargetString, this);
		theFrame.addKeyListener(myComparisonGrid);

		setPanelSettings();

	}

	/**
	 * This method sets all of the JPanel settings. such as Background color...
	 */
	private void setPanelSettings()
	{
		this.setBackground(Color.WHITE);

		setFocusable(true);
		setVisible(true);
	}

	/**
	 * This method returns the text that is contained in the passed File
	 * variable.
	 * 
	 * @param theFile
	 *            the file that we want text from
	 * @return the string containing the text from the File.
	 */
	private String getFileText(File theFile)
	{
		String toReturn = "";
		try
		{
			Scanner input = new Scanner(theFile);
			while (input.hasNext())
			{
				toReturn += input.next() + " ";
			}
			input.close();

		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return toReturn;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawText(g);
	}

	/**
	 * This method is called from paintComponent. This method correctly displays
	 * the text from myTargetString based on values contained in
	 * myComparisonGrid.
	 * 
	 * @param g
	 *            the Graphics object we are using in paintComponent.
	 */
	private void drawText(Graphics g)// needs to do text wrap.
	{
		Graphics2D g2d = (Graphics2D) g;
		char[] theCharsToDraw = myTargetString.toCharArray();

		for (int i = 0; i < theCharsToDraw.length; i++)
		{

			if (myComparisonGrid.getMyComparisonGrid() != null
					&& myComparisonGrid.getMyComparisonGrid().size() > i)
			{

				switch (myComparisonGrid.getMyComparisonGrid().get(i))
				{
					case 3:
						g2d.setColor(Color.GRAY);
						g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
						break;
					case 0:
						g2d.setColor(Color.GREEN);
						g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
						break;
					case 1:
						g2d.setColor(Color.RED);
						g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
						break;
					case 2:
						g2d.setColor(Color.RED);
						g2d.setFont(new Font("TimesRoman", Font.ITALIC, 20));
						break;
				}
			}
			else
			{
				g2d.setColor(Color.BLACK);
				g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			}

			int x = (i * 10) % 500;
			int y = (((i * 10) / 500) * 25) + 25;
			g2d.drawString(theCharsToDraw[i] + "", x, y);
		}

	}

	@Override
	public void update(Observable o, Object arg)
	{

		if (arg instanceof ComparisonGrid)
		{
			myComparisonGrid = (ComparisonGrid) arg;
		}
		repaint();

	}

}
