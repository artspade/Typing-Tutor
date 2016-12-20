package view;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 
 * @author Rowan Meier
 *
 */
public class GuiTextDisplayPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -446079737054386501L;
	private String myDisplayText; // text to be displayed in this JPanel

	public GuiTextDisplayPanel() {
		myDisplayText = ""; 
	}

	/**
	 * paints the string onto the screen.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawString(myDisplayText, 20, 20);
		//TO-DO
	}

	public void setMyDisplayText(String myDisplayText) {
		this.myDisplayText = myDisplayText;
	}

}
