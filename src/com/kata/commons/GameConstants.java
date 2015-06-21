package com.kata.commons;

public interface GameConstants {
	
	public static final int MAX_ROLLS = 2;
	public static final int MAX_SCORE = 10;
	public static final int MAX_PENDING_FRAMES = 2;
	
	public interface Actions{
		public static final char STRIKE = 'X';
		public static final char SPARE = '/';
		public static final char MISS = '-';
		public static final char NORMAL = '+';
		
	}

}
