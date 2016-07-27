package A3;

/**
* @file PlayerTTT.java
* @author Keagan Banks
* @date 26 Nov 2014
* 
* 
* Gets and sets player ifnormation for TicTacToe
*/
public class PlayerTTT {
	private String m_PlayerName;
	private String Symbol;
	private String PlayerType;
	private int m_boardSize = 9;
	private int[][] m_PlayerPositionTTT = new int[m_boardSize][m_boardSize];

	public PlayerTTT(String Name, String Symbol, String playerType) {
		this.m_PlayerName = Name;
		this.Symbol = Symbol;
		this.m_PlayerPositionTTT = new int[m_boardSize][m_boardSize];
		this.PlayerType = PlayerType;

	}
	/**
	* returns plays name when called
	* @param getName to return the players name
	*/ 
	
	public String getName() {
		return m_PlayerName;
	}
	/**
	* returns the symbol (X or O)
	* @param getSymbol to return the players symbol
	*/
	public String getSymbol() {
		return Symbol;
	}
	/**
	* Store players position in a array
	* @param getPlayerPOisitionTTT to then store m_PlayerPositionTTT in an array
	*/
	public int[][] getPlayerPositionTTT() {
		return m_PlayerPositionTTT;
	}
	/**
	* returns the PlayerType
	* @param getPlayerType to return the players type
	*/
	public String getPlayerType() {
		return PlayerType;
	}

	/**
	* sets the players name to equal the string name
	* @param setName to make m_PlayerName equal Name
	*/
	public void setName(String Name) {
		this.m_PlayerName = Name;
	}
	/**
	* sets the players symbol to equal symbol
	* @param setSymbol to make Symbol equal Symbol
	*/
	public void setSymbol(String Symbol) {
		this.Symbol = Symbol;
	}
	/**
	* sets the players Type to equal the string PlayerType
	* @param setPlayerType to make PlayerType equal PlayerType
	*/
	public void setPlayerType(String PlayerType) {
		this.PlayerType = PlayerType;
	}

	/**
	* sets the Player Position to int x,y, record
	* @param setPlayerPosition to make m_PPlayerPosition array int x,y equal record 
	*/
	public void setPlayerPositionTTT(int x, int y, int record) {
		this.m_PlayerPositionTTT[x][y] = record;
	}
	


	}


