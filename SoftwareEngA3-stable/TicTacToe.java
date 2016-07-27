/**
* @file TicTacToe.java
* @author Russell Macleod
* @date 26 Nov 2014
* @see TicTacToeGui.java to get a players move.
* @see PlayerTTT.java to store player positions and access symbol.
* @see Win.java to check if a player has won after a move.
*
* Logic and list of moves for TicTacToe game and players, also calls win class.
*/

package A3;
import java.util.ArrayList;

public class TicTacToe {

	private static final int AREA = 8;
	private PlayerTTT[] m_playersTTT = new PlayerTTT[2];
	private static int[][] m_playerPositionsTTT = new int [AREA][AREA];
	private static ArrayList<PlayerTTT> playerList = new ArrayList<PlayerTTT>();
	private static PlayerTTT player;

	// public static void main(String[] args){

	// 	PlayerTTT player = new PlayerTTT("joe", "x", "human");
	// 	playerList.add(player);

	// 	PlayerTTT player1 = new PlayerTTT("bloggs", "o", "human");
	// 	playerList.add(player1);

	// 	setPositionsTTT(0, 2, 1);
	// 	setPositionsTTT(1, 3, 1);

	// 	PlayerTTT testPlayer = playerList.get(1);
	// 	testPlayer.setPlayerPositionTTT(1,1,1);
	// 	System.out.println(getPositionTTT(1));
	// 	System.out.println("test");
	// }
	/**
	* Set method used to store instances of PlayerTTT in an array.
	* @param A method variable array of PlayerTTT.
	* @see Initial
	*/
	public void setPlayersTTT (PlayerTTT[] players){
		m_playersTTT = players;
    }
	
	/**
	* Accessor method of array of instances of playerTTT.
	* @param the number of the player to be accessed.
	* @see CalculateResults
	* @return instance of PlayerTTT
	*/
	public PlayerTTT getPlayersTTT (int player){
		return m_playersTTT[player];
    }
	
	/**
	* Accessor method used to find the player positions array.
	* @see TicTacToeGui()
	* @return m_playerPositionsTTT
	*/
	public static int[][] getPositionTTT(int playerID){
		player = playerList.get(playerID);
		return player.getPlayerPositionTTT();
	}
	
	/**
	* Set method used to add a players move into player position array.
	* @param player an integer argument, which players turn.
	* @param position an integer argument, new symbol position within array.
	* @see TicTacToeGui()
	* @see instance of PlayerTTT()
	* @see Win.()
	* @return null
	*/
	
	

	public static void setPositionsTTT(int player, int x, int y){
			playerList.get(player).setPlayerPositionTTT(x, y, 1);
		
	}
}
