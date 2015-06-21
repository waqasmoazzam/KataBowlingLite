package com.kata;

import java.util.ArrayList;
import java.util.LinkedList;

import com.kata.commons.GameConstants;
import com.kata.commons.GameConstants.Actions;
import com.kata.pojos.Frame;
import com.kata.pojos.Line;
import com.kata.pojos.Roll;

public class KataBowlingLiteImplementation {

	Line line;

	private LinkedList<Frame> pendingScore;

	public int calculateScore(char[] inputRolls) {

		line = new Line();
		pendingScore = new LinkedList<Frame>();

		int length = inputRolls.length;
		char input = ' ';
		int scoreValue = 0;

		for (int i = 0; i < length; i++) {

			input = inputRolls[i];

			switch (input) {
			case Actions.STRIKE:
				handleStrike(i, GameConstants.MAX_SCORE);
				break;
			case Actions.SPARE:
				scoreValue = Character.getNumericValue(inputRolls[i - 1]);
				if (scoreValue < 0) {
					scoreValue = 0;
				}
				handleSpare(length, i, (GameConstants.MAX_SCORE - scoreValue));
				break;
			case Actions.MISS:
				handleNonStrikeRolls(length, i, 0, Actions.MISS);
				break;
			default:
				scoreValue = Character.getNumericValue(input);
				handleNonStrikeRolls(length, i, scoreValue, Actions.NORMAL);
				break;
			}
		}
		return line.getTotalScore();

	}

	private void handleStrike(int index, int scoreValue) {

		handlePendingFrames(scoreValue);

		Roll roll = new Roll();
		roll.setNoOfPinsHit(GameConstants.MAX_SCORE);
		roll.setRollType(Actions.STRIKE);

		Frame frame = new Frame();
		frame.addRoll(roll);
		frame.setFrameType(Actions.STRIKE);

		line.addFrame(frame);
		pendingScore.add(frame);

	}

	private void handleSpare(int inputSize, int index, int scoreValue) {

		Frame frame = handleNonStrikeRolls(inputSize, index, scoreValue, Actions.SPARE);		
		pendingScore.add(frame);

	}

	private Frame handleNonStrikeRolls(int inputSize, int index, int scoreValue, char type) {

		
		handlePendingFrames(scoreValue);

		Roll roll = new Roll();
		roll.setNoOfPinsHit(scoreValue);
		roll.setRollType(type);

		ArrayList<Frame> frames = line.getFrames();
		int size = frames.size();

		Frame frame = null;
		if (size > 0 && (index % 2) != 0) {
			frame = frames.get(size - 1);
			if (type == Actions.SPARE) {
				line.updateFrameScore(frame);
			}
		} else {
			frame = new Frame();
		}

		frame.addRoll(roll);
		frame.setFrameType(type);

		if (frame.getRolls().size() < GameConstants.MAX_ROLLS) {
			line.addFrame(frame);
		} else {
			line.updateFrameScore(frame);
			
		}
		return frame;
	}

	public void handlePendingFrames(int bonusScore) {

		Frame pendingFrame = pendingScore.peekLast();
		if (pendingFrame != null) {
			pendingFrame.addBonusScore(bonusScore);
			if (pendingFrame.getNoOfBonus() == 2) {
				pendingScore.pollLast();
			}
			if (pendingFrame.getFrameType() == Actions.SPARE) {
				pendingScore.pollLast();
			} else {
				if (pendingScore.size() == GameConstants.MAX_PENDING_FRAMES) {
					Frame headFrame = pendingScore.pollFirst();
					headFrame.addBonusScore(bonusScore);
					line.updateFrameScore(headFrame);
				}
			}
		}
	}
}
