/**
* @file SnakePoints.java
* @author Keagan Banks
* @date 27 Nov 2014
* 
*
* Creates and stores information for players in the Snakes and Ladders game
*/


package A3;
import A3.*;
public class PlayerSAL {
	private String m_playerName;
	private String m_playerColour;
	private int m_playerPosition;
	
	public PlayerSAL(String name, String colour, int position){
		setName(name);
		setColour(colour);
		setPlayerPosition(position);
	}
	
	public void setName(String name){							
		m_playerName = name;				
	}		 
	
	public void setColour(String colour){							
		m_playerColour = colour;				
	}
	
	public void setPlayerPosition(int position ){							
		m_playerPosition = position;			
	}
	
	public String getName(){
		return m_playerName;		
	}
	
	public String getColour(){
		return m_playerColour;		
	}
	
	public int getPlayerPosition(){
		return m_playerPosition;		
	}	
	
	public String toString() {
		return("\n"+"Player Name: "+m_playerName+"\nPlayer Colour: "+m_playerColour+
				"\nPlayer Position: "+m_playerPosition);
	}	
	
	/**
	 * returns player names when called
	 * @param getName to return the names
	 */
}
 
