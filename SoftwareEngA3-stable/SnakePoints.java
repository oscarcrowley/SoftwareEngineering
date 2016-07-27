package A3;

/**
 * @file SnakePoints.java
 * @author Avishek Siris
 * @date 26 Nov 2014
 * @see SnakesAndLadders.java
 * 
 * @Brief Class to create object containing the head and tail points of snake
 * 
 */

public class SnakePoints {	
	private int snakeHead;
	private int snakeTail;
	
	/**
	 * Constructor of class 
	 * @param int head, head point of snake
	 * @param int tail, tail point of snake
	 */	
	public SnakePoints(int head, int tail){
		snakeHead = head;
		snakeTail = tail;
	}
	
	/**
	 * Method to return snake head point
	 * @return int snakeHead
	 */	
	public int getSnakeHead(){
		return snakeHead;
	}
	
	/**
	 * Method to return snake tail point
	 * @return int snakeTail
	 */	
	public int getSnakeTail(){
		return snakeTail;
	}	
}
