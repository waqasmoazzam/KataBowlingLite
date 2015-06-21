package com.kata.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kata.KataBowlingLiteImplementation;

public class KataBowlingLiteTest {
	


	@Test
	public void calculateScoreTest() {

		KataBowlingLiteImplementation bowlingImplementation = new KataBowlingLiteImplementation();
		
		char[] inputRolls1 = {'X','X','X','X','X','X','X','X','X','X','X','X'};
		assertEquals(300, bowlingImplementation.calculateScore(inputRolls1));
		
		char[] inputRolls2 = {'9','-','9','-','9','-','9','-','9','-','9','-','9','-','9','-','9','-','9','-'};
		assertEquals(90, bowlingImplementation.calculateScore(inputRolls2));
		
		char[] inputRolls3 = {'-','/','-','/','-','/','-','/','-','/','-','/','-','/','-','/','-','/','-','/','-'};
		assertEquals(100, bowlingImplementation.calculateScore(inputRolls3));
		
		char[] inputRolls4 = {'3','3','-','-','-','-','3','3','3','3','3','3','3','3','3','3','3','3','3','/','3'};
		assertEquals(55, bowlingImplementation.calculateScore(inputRolls4));
		
		char[] inputRolls5 = {'5','/','5','/','5','/','5','/','5','/','5','/','5','/','5','/','5','/','5','/','5'};
		assertEquals(150, bowlingImplementation.calculateScore(inputRolls5));
	}

}
