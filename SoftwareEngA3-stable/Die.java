package A3;

/**
* @file Die.java
* @author Patrick Schlumberger Socha
* @date 2 Dec 2014
*
* Simple die class
*/

public class Die {
	
	private static final int maxBound = 6;

	/**
	* Returns a random int between 1 and the maxBound
	* @param int maxBound
	* @return Random int between 1 and maxBound
	*/
	public static int generate(){
		return (int)((Math.random() * maxBound) + 1);
	}
}
