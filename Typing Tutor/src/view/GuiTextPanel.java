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

public class GuiTextPanel extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1421873357843121287L;
	
	// private TextBuilder myTextBuilder;
	private String myTargetString;
	private ComparisonGrid myComparisonGrid;

	public GuiTextPanel(JFrame theFrame) {
		myTargetString = getFileText(
				"C:\\Users\\rowan\\Desktop\\Eclipse_Java_Workspace\\Typing Tutor\\src\\recources\\words_to_type.txt");
		myComparisonGrid = new ComparisonGrid(myTargetString, this);
		theFrame.addKeyListener(myComparisonGrid);
		//this.addKeyListener(myComparisonGrid);
		
		setPanelSettings();
		setFocusable(true);
		setVisible(true);

	}

	private void setPanelSettings() {
		this.setBackground(Color.WHITE);
	}

	private String getFileText(String theFilePath) {
		String toReturn = "";
		try {
			Scanner input = new Scanner(new File(theFilePath));
			while (input.hasNext()) {
				toReturn += input.next() + " ";
			}
			input.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toReturn;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawText(g);
	}

	private void drawText(Graphics g)// needs to do text wrap.
	{
		Graphics2D g2d = (Graphics2D) g;
		char[] theCharsToDraw = myTargetString.toCharArray();

		for (int i = 0; i < theCharsToDraw.length; i++) {

			if (myComparisonGrid.getMyComparisonGrid() != null && myComparisonGrid.getMyComparisonGrid().size() > i) {

				switch (myComparisonGrid.getMyComparisonGrid().get(i)) {
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
			} else {
				g2d.setColor(Color.BLACK);
				g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			}

			/*
			 * if(myComparisonGrid.get(i) == -1) { g2d.setColor(Color.GRAY);
			 * g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20)); } else {
			 * if(myComparisonGrid.get(i) == 0) {
			 * 
			 * } else { if(myComparisonGrid.get(i) == 1) {
			 * 
			 * } else { if(myComparisonGrid.get(i) == 2) {
			 * 
			 * } } } }
			 */

			int x = (i * 10) % 500;
			int y = (((i * 10) / 500) * 25) + 25;
			g2d.drawString(theCharsToDraw[i] + "", x, y);

			// g2d.drawChars(theCharsToDraw, 1, 10 , 0, 25);
		}
		// g2d.drawChars(theCharsToDraw, 1, 1 , 0, 25);
		// g2d.drawChars(theCharsToDraw, 0, theCharsToDraw.length-2 , 0, 25);

	}

	@Override
	public void update(Observable o, Object arg) {

		System.out.println("In GuiTextPanel Update");
		if (arg instanceof ComparisonGrid) {
			myComparisonGrid = (ComparisonGrid) arg;
			System.out.println("In GuiTextPanel Update ComparisonGrid Found");
		}
		repaint();

	}


}
