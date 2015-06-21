package com.kata.pojos;

import java.util.ArrayList;

public class Line {
	private ArrayList<Frame> frames;
	private int totalScore;
	
	public Line() {
		super();
		this.frames = new ArrayList<Frame>();
		this.totalScore = 0;
	}
	
	public Line(ArrayList<Frame> frames, int totalScore) {
		super();
		this.frames = frames;
		this.totalScore = totalScore;
	}
	

	public ArrayList<Frame> getFrames() {
		return frames;
	}
	public void setFrames(ArrayList<Frame> frames) {
		this.frames = frames;
	}
	
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	public void addFrame(Frame frame){
		frames.add(frame);
	}
	
	public void updateFrameScore(Frame frame){
		totalScore += (frame.getScore() + frame.getBonusScore());
	}
	
	

}
