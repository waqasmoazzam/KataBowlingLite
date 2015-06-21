package com.kata.pojos;

import java.util.ArrayList;

public class Frame {
	
	private ArrayList<Roll> rolls;
	private int score;
	private int bonusScore;
	private char frameType;
	private int noOfBonus;
	
	public Frame() {
		super();
		this.rolls = new ArrayList<Roll>();
		this.score = 0;
		this.bonusScore = 0;
		this.noOfBonus = 0;
		

	}

	public ArrayList<Roll> getRolls() {
		return rolls;
	}

	public void setRolls(ArrayList<Roll> rolls) {
		this.rolls = rolls;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getBonusScore() {
		return bonusScore;
	}

	public void setBonusScore(int bonusScore) {
		this.bonusScore = bonusScore;
	}
	
	public char getFrameType() {
		return frameType;
	}

	public void setFrameType(char frameType) {
		this.frameType = frameType;
	}
	
	public int getNoOfBonus() {
		return noOfBonus;
	}

	public void setNoOfBonus(int noOfBonus) {
		this.noOfBonus = noOfBonus;
	}

	public void addRoll(Roll roll){
			rolls.add(roll);
			score += roll.getNoOfPinsHit();
	}
	
	public void addBonusScore(int scoreValue){
		noOfBonus++;
		bonusScore += scoreValue;
	}
}
