package model;

import java.util.Observable;
import java.util.Observer;

/**
 * 
 * @author Rowan Meier
 *	
 *	needs to observe a class which updates a the string being typed.
 *	If this is done you will be able to keep track of accuracy.
 */
public class CharacterLevelStringCompare implements Observer
{
	private String myString1; // the string to match against.
	private String myString2;
	/**
	 * 0 indicates they are equal.
	 * 1 indicates a mismatch.
	 */
	private int[] myComparisonArray;

	public CharacterLevelStringCompare(String theString1, String theString2)
	{
		myString1 = theString1;
		myString2 = theString2;
		//create an array who's size is large enough to hold the longest string.
		int theLargestLength = (myString1.length() > myString2.length()) ? myString1.length() : myString2.length();
		int theSmallestLength = (myString1.length() < myString2.length()) ? myString1.length() : myString2.length();
		myComparisonArray = new int[theLargestLength]; 
		buildComparisonArray(theSmallestLength);
		padComparisonArrayEnding(theSmallestLength, theLargestLength);
		
	}
	
	private void buildComparisonArray(int theSmallestLength)
	{
		for(int i = 0; i < theSmallestLength; i++)
		{
			myComparisonArray[i] = (myString1.charAt(i) == myString2.charAt(i)) ? 0 : 1;
		}
	}
	
	private void padComparisonArrayEnding(int theStartIndex, int theEndIndex)
	{
		for(int i = theStartIndex; i < theEndIndex; i++)
		{
			myComparisonArray[i] = -1;
		}
	}
	
	private void updateMyComparisonArray(int thePreviousLength)
	{
		for(int i = thePreviousLength; i < myString2.length(); i++)
		{
			myComparisonArray[i] = (myString1.charAt(i) == myString2.charAt(i)) ? 0 : 1;
		}
	}
	public int[] getMyComparisonArray()
	{
		return myComparisonArray;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if(arg instanceof String)
		{
			int currentLength = myString2.length();
			myString2 = (String)arg;
			updateMyComparisonArray(currentLength);
		}
		
	}
	

}
