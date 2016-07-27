package A3;

/**
 * @file LadderPoints.java
 * @author Avishek Siris
 * @date 26 Nov 2014
 * @see SnakesAndLadders.java
 * 
 * @Brief Class to create object containing the top and bottom points of ladder
 * 
 */

public class LadderPoints {	
	private int ladderTop;
	private int ladderBottom;
	
	/**
	 * Constructor of class 
	 * @param int top, top point of ladder
	 * @param int bottom, bottom point of ladder
	 */	
	public LadderPoints(int top, int bottom){
		ladderTop = top;
		ladderBottom = bottom;
	}
	
	/**
	 * Method to return ladder top point
	 * @return int ladderTop
	 */	
	public int getLadderTop(){
		return ladderTop;
	}
	
	/**
	 * Method to return ladder bottom point
	 * @return int ladderBottom
	 */	
	public int getLadderBottom(){
		return ladderBottom;
	}	
}
