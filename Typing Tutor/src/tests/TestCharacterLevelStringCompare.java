package tests;

import static org.junit.Assert.*;

import java.util.Observable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.StringComparisonGrid;

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
	public void testUpdate()
	{
		StringComparisonGrid comparisonArray = new StringComparisonGrid("String 1","String 2");
		@SuppressWarnings("unused")
		StringComparisonGrid comparisonArray1 = new StringComparisonGrid("String","String 2");
		@SuppressWarnings("unused")
		StringComparisonGrid comparisonArray2 = new StringComparisonGrid("String 1","String");
		
		comparisonArray.update(new Observable(),"String 1");
		System.out.println(comparisonArray.getMyComparisonArray().toString());
		assertTrue(Stream.of(0,0,0,0,0,0,0,0).collect(Collectors.toList()).equals(comparisonArray.getMyComparisonArray()));
		
		comparisonArray.update(new Observable(), "String String");
		System.out.println(comparisonArray.getMyComparisonArray().toString());
		assertTrue(Stream.of(0,0,0,0,0,0,0,1,2,2,2,2,2).collect(Collectors.toList()).equals(comparisonArray.getMyComparisonArray()));
		
		comparisonArray.update(new Observable(), "Str");
		System.out.println(comparisonArray.getMyComparisonArray().toString());
		assertTrue(Stream.of(0,0,0,-1,-1,-1,-1,-1).collect(Collectors.toList()).equals(comparisonArray.getMyComparisonArray()));
		
		comparisonArray.update(new Observable(), "Sti");
		System.out.println(comparisonArray.getMyComparisonArray().toString());
		assertTrue(Stream.of(0,0,1,-1,-1,-1,-1,-1).collect(Collectors.toList()).equals(comparisonArray.getMyComparisonArray()));
		
		comparisonArray.update(new Observable(), "Dude");
		System.out.println(comparisonArray.getMyComparisonArray().toString());
		assertTrue(Stream.of(1,1,1,1,-1,-1,-1,-1).collect(Collectors.toList()).equals(comparisonArray.getMyComparisonArray()));
		
		comparisonArray.update(new Observable(), "Duden");
		System.out.println(comparisonArray.getMyComparisonArray().toString());
		assertTrue(Stream.of(1,1,1,1,0,-1,-1,-1).collect(Collectors.toList()).equals(comparisonArray.getMyComparisonArray()));
	}

	
	@Test
	public void testCharacterLevelStringCompare() {
		
	
		
	}



}
