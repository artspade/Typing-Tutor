package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.CharacterLevelStringCompare;

public class TestCharacterLevelStringCompare {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCharacterLevelStringCompare() {
		int[] comparisonArray1 = new CharacterLevelStringCompare("String 1","String 2").getMyComparisonArray();
		int[] comparisonArray2 = new CharacterLevelStringCompare("String 10","String 2").getMyComparisonArray();
		int[] comparisonArray3 = new CharacterLevelStringCompare("String 1","String 20").getMyComparisonArray();
		int[] comparisonArray1DesiredResult = {0,0,0,0,0,0,0,1};
		int[] comparisonArray1UndesiredResult = {0,0,0,0,0,0,0,0};
		int[] comparisonArray2DesiredResult = {0,0,0,0,0,0,0,1,1};
		int[] comparisonArray2UndesiredResult = {0,0,0,0,0,0,0,0,0};
		int[] comparisonArray3DesiredResult = {0,0,0,0,0,0,0,1,1};
		int[] comparisonArray3UndesiredResult = {0,0,0,0,0,0,0,1};
		
		
		assertTrue(comparisonArray1.equals(comparisonArray1));
		assertTrue(compareIntArrays(comparisonArray1, comparisonArray1));
		assertFalse(compareIntArrays(comparisonArray1, comparisonArray1UndesiredResult));
		assertTrue(compareIntArrays(comparisonArray1, comparisonArray1DesiredResult));
		
		assertTrue(comparisonArray2.equals(comparisonArray2));
		assertTrue(compareIntArrays(comparisonArray2, comparisonArray2));
		assertFalse(compareIntArrays(comparisonArray2, comparisonArray2UndesiredResult));
		assertTrue(compareIntArrays(comparisonArray2, comparisonArray2DesiredResult));
		
		assertTrue(comparisonArray3.equals(comparisonArray3));
		assertTrue(compareIntArrays(comparisonArray3, comparisonArray3));
		assertFalse(compareIntArrays(comparisonArray3, comparisonArray3UndesiredResult));
		assertTrue(compareIntArrays(comparisonArray3, comparisonArray3DesiredResult));
		
	}
	private boolean compareIntArrays(int[] intArray1, int[] intArray2)
	{
		boolean toReturn = true;
		
		if(intArray1.length != intArray2.length)
		{
			toReturn = false;
		}
		else
		{
			for(int i = 0; i < intArray2.length; i++)//intArray1 or intArray2 length does not matter being that they are equal at this point
			{
				if(intArray1[i] != intArray2[i])
				{
					toReturn = false;
					break;
				}
			}
		}
		
		
		
		
		
		
		
		
		return toReturn;
	}



}
