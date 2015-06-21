package com.kata.pojos;

import com.kata.commons.GameConstants.Actions;

public class Roll {
	private int noOfPinsHit;
	private char rollType;	
	
	public Roll() {
		super();
	}
	
	public Roll(int noOfPinsHit, char rollType) {
		super();
		this.noOfPinsHit = noOfPinsHit;
		this.rollType = rollType;
	}

	public int getNoOfPinsHit() {
		return noOfPinsHit;
	}
	
	public void setNoOfPinsHit(int noOfPinsHit) {
		this.noOfPinsHit = noOfPinsHit;
	}
	
	public char getRollType() {
		return rollType;
	}
	
	public void setRollType(char rollType) {
		this.rollType = rollType;
	}
	
	public void initilaizeRoll(int noOfPinsHit){
		
	}

	
}
