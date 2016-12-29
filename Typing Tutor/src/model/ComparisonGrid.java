package model;

import java.util.List;
import java.util.Observable;

import view.GuiTextPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class ComparisonGrid extends Observable implements KeyListener
{

	/**Marks that at this index in both the current and target strings both characters are equal. */
	private static final int FLAG_EQUAL = 0;
	/**Marks that at this index in both the current and target strings both characters are unequal. */
	private static final int FLAG_UNEQUAL = 1;
	/**Marks that at this index the user typed over what the size of the target string is. */
	private static final int FLAG_TEXTOVERFLOW = 2;
	/**Marks that at this index in the target string the user is yet to type to this length */
	private static final int FLAG_UNWRITTEN = 3;

	private int mySmallestLength;
	/**The string we are trying to match against */
	private String myTargetString; 
	/**The string we want to match myTargetString with */
	private String myCurrentString;
	
	private List<Integer> myComparisonGrid;
	


	public ComparisonGrid(String theTargetString, GuiTextPanel theTextPanel)
	{
		mySmallestLength = 0;
		myTargetString = theTargetString;
		myCurrentString = "";
		myComparisonGrid = buildComparisonArray();
	    this.addObserver(theTextPanel);
	    this.setChanged();
		notifyObservers(this);
	}
	
	/**
	 * This method builds the comparison array
	 * @param theSmallestLength the length of the smallest of the two strings (target vs current)
	 * @return a properly configured comparison array.
	 */
	public List<Integer> buildComparisonArray()
	{
		List<Integer> toReturn = new ArrayList<Integer>();
		for(int i = 0; i < mySmallestLength; i++)
		{
			toReturn.add((myTargetString.charAt(i) == myCurrentString.charAt(i)) ? FLAG_EQUAL : FLAG_UNEQUAL); 
		}
		
		if(myCurrentString.length() > myTargetString.length())
		{
			
			setOverflowComparisonArray(mySmallestLength, myCurrentString.length(), toReturn);
		}
		else
		{
			if(myCurrentString.length() < myTargetString.length() )
			{
			padComparisonArrayEnding(mySmallestLength, myTargetString.length(), toReturn);
			}
		}
	
		
		
		return toReturn;
	}
	
	/**
	 * Adds the FLAG_TEXTOVERFLOW to the comparisonArray. *Should only be called when myCurrentString.length() > myTargetString.length()* 
	 * @param theStartIndex the length of the smallest string
	 * @param theEndIndex the length of the largest string
	 * @param theToReturn the comparison array
	 * @return the comparison array with added TEXTOVERFLOW FLAGs
	 */
	private List<Integer> setOverflowComparisonArray(int theStartIndex, int theEndIndex, List<Integer> theToReturn)
	{
		
		for(int i = theStartIndex; i < theEndIndex; i++)
		{
			theToReturn.add(FLAG_TEXTOVERFLOW);
		}
		
		return theToReturn;
	}
	
	/**
	 * Adds the FLAG_UNWRITTEN to the comparisonArray. *Should only be called when myCurrentString.length() < myTargetString.length()* 
	 * @param theStartIndex the length of the smallest string
	 * @param theEndIndex the length of the largest string
	 * @param theToReturn the comparison array
	 * @return the comparison array with added UNWRITTEN FLAGs
	 */
	private List<Integer> padComparisonArrayEnding(int theStartIndex, int theEndIndex, List<Integer> theToReturn)
	{
		for(int i = theStartIndex; i < theEndIndex; i++)
		{
			theToReturn.add(FLAG_UNWRITTEN);
		}
		
		return theToReturn;
	}
	
	public List<Integer> getMyComparisonGrid() {
		return myComparisonGrid;
	}





	@Override
	public void keyPressed(KeyEvent e) {
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Key Pressed");
		char theKeyChar = e.getKeyChar();
		System.out.println(myCurrentString);
		switch(theKeyChar)
		{
		
		case  (char)8://backspace
			myCurrentString = myCurrentString.substring(0, myCurrentString.length()-1);
			break;
		default:
			myCurrentString += theKeyChar;
			break;
		}
		System.out.println(myCurrentString);
		mySmallestLength = (myCurrentString.length() < myTargetString.length()) ? myCurrentString.length() : myTargetString.length();
		myComparisonGrid = buildComparisonArray();
		this.setChanged();
		notifyObservers(this);
	}

}
