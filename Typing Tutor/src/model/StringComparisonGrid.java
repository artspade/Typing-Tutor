package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 
 * @author Rowan Meier
 *	
 *	needs to observe a class which updates a the string being typed.
 *	If this is done you will be able to keep track of accuracy of the typed string compared to the target.
 */
public class StringComparisonGrid implements Observer
{
	/**Marks that at this index in both the current and target strings both characters are equal. */
	private static final int FLAG_EQUAL = 0;
	/**Marks that at this index in both the current and target strings both characters are unequal. */
	private static final int FLAG_UNEQUAL = 1;
	/**Marks that at this index the user typed over what the size of the target string is. */
	private static final int FLAG_TEXTOVERFLOW = 2;
	/**Marks that at this index in the target string the user is yet to type to this length */
	private static final int FLAG_UNWRITTEN = -1;
	/**The string we are trying to match against */
	private String myTargetString; // the string to match against.
	/**The string we want to match myTargetString with */
	private String myCurrentString;
	/**A list of integers that represent different FLAGS for comparing the characters held in both
	 * myCurrentString and myTargetString. The FLAGS are listed as constants within this class. */
	private List<Integer> myComparisonArray;

	/**
	 * Default constructor for the StringComparisonGrid. 
	 * @param theString1 The target string
	 * @param theString2 the string we want to match the target string.
	 */
	public StringComparisonGrid(String theString1, String theString2)
	{
		myTargetString = theString1;
		myCurrentString = theString2;
		//create an array who's size is large enough to hold the longest string.
		int theSmallestLength = (myTargetString.length() < myCurrentString.length()) ? myTargetString.length() : myCurrentString.length();
		myComparisonArray = new ArrayList<Integer>(100); 
		buildComparisonArray(theSmallestLength);
		
	}
	
	/**
	 * This method builds the comparison array
	 * @param theSmallestLength the length of the smallest of the two strings (target vs current)
	 * @return a properly configured comparison array.
	 */
	private List<Integer> buildComparisonArray(int theSmallestLength)
	{
		List<Integer> toReturn = new ArrayList<Integer>();
		for(int i = 0; i < theSmallestLength; i++)
		{
			toReturn.add((myTargetString.charAt(i) == myCurrentString.charAt(i)) ? FLAG_EQUAL : FLAG_UNEQUAL); 
		}
		
		if(myCurrentString.length() > myTargetString.length())
		{
			int theLargestLength = (myTargetString.length() > myCurrentString.length()) ? myTargetString.length() : myCurrentString.length();
			setOverflowComparisonArray(theSmallestLength, theLargestLength, toReturn);
		}
		
		if(myCurrentString.length() < myTargetString.length())
		{
			int theLargestLength = (myTargetString.length() > myCurrentString.length()) ? myTargetString.length() : myCurrentString.length();
			padComparisonArrayEnding(theSmallestLength, theLargestLength, toReturn);
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

	

	public List<Integer> getMyComparisonArray()
	{
		return myComparisonArray;
	}
	

	@Override
	public void update(Observable o, Object arg) {
		
			if(arg instanceof String)
			{
				myCurrentString = (String)arg;
				int theSmallestLength = (myTargetString.length() < myCurrentString.length()) ? myTargetString.length() : myCurrentString.length();
				myComparisonArray = buildComparisonArray(theSmallestLength);

			
			}

		
		
		
	}
	

}
