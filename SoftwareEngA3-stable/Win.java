package A3;

// import A3.PlayerTTT;

/**
* @file Win.java
* @author Russell Macleod
* @date 26 Nov 2014
* @see TicTacToe.java; called from to check if in a winning position.
* @see SnakesAndLadders.java; called from to check if in a winning position.
* @see TicTacToeGui.java; calls if player has not won.
* @see SnakesAndLaddersGui.java; calls if player has not won.
* @see ResultsGUI.java; calls if player has won.
*
* @Brief Checks if player positions are in a winning position for both games
* and calls calls the results GUI if true or the game GUI if not.
*/

public class Win {
	
	private static final int WIN_CONDITION_SAL = 100;
	private static final int WIN_COND_TTT = 5;
	private static final int TTT_BOARD_AREA = 8;
	private static int[][] m_winPositionsTTT = new int [WIN_COND_TTT][WIN_COND_TTT];
	
	/**
	* Checks if a player has won a game of Tic Tac Toe.
	* @param player an int; records which player has made the move.
	* @param playerPositions; a 2 dimensional int array, players positions.	
	* @see TicTacToeGui.getMove(); calls if player has not won.
	* @see CalculateResults.getWinningPlayer(); calls if player has won.
	* @see m_winAcross(int[][]); calls.
	* @see m_winDown(int[][]); calls.
	* @see m_winDiagRight(int[][]); calls.
	* @see m_winDiagLeft(int[][]); calls.
	* @see TicTacToe.setPositionsTTT(); called by.
	*/
	public static boolean m_checkTTTWin (PlayerTTT player, String time){
		//Sets won condition to false unless win condition is met.
		boolean won = false;
		//Checks 5 symbols in a row anywhere across the board.
		if (m_winAcross(player.getPlayerPositionTTT())){
			won = true;
		//Checks 5 symbols in a row anywhere down the board.
		}else if (m_winDown(player.getPlayerPositionTTT())){
			won = true;
		//Checks if 5 symbols in a row anywhere down and right of the board.
		}else if (m_winDiagRight(player.getPlayerPositionTTT())){
			won = true;
		//Checks if 5 symbols in a row anywhere down and left of the board.
		}else if (m_winDiagLeft(player.getPlayerPositionTTT())){
			won = true;
		}
		if (won){
			//If player has won call calculate results class.
			// ResultsGUI.m_displayResults(player,m_winPositionsTTT);
			ResultsGUI.m_displayResults(player, time);
			// System.out.println("Won!!");
			// for (int i = 0; i < TTT_BOARD_AREA; i++){
			// 	System.out.println("");
			//     for (int j = 0; j < TTT_BOARD_AREA; j++){
			//     	System.out.print(m_winPositionsTTT[i][j] + " ");
			// return m_winPositionsTTT[i][j];
			//     }
			// }
			System.out.println("Win!");

			return won;
		}

		return won;
	}

	public static void setWinningPosition(int[][] winningPositions){

		m_winPositionsTTT = winningPositions;

	}

	public static int[][] getWinningPosition(){

	return m_winPositionsTTT;

	}

	/**
	* Check if the players positions across the board are in a winning position.
	* @param playerPositions an integer array, check if in a winning combination.	
	* @see m_checkTTTWin(); called by.
	* @return won; if a player has a wining position returns true else false.
	*/
	private static boolean m_winAcross(int [][] playerPositionAcross){	
		//Sets won condition to false unless win condition is met.
		boolean won = false;
		//Loop through horizontal axis of board minus winning condition number 
		//of times, as these will be used by and inner loop.
		for (int i = 0; i < TTT_BOARD_AREA - WIN_COND_TTT + 1; i++){
			//Loop through vertical axis of board.
			for (int j = 0; j < TTT_BOARD_AREA; j++){
				//Stores how many positions in a row a player has.
				int score = 0;
				//Initialise variable holding checked positions.
				int[][] winPositionsTTT = new int [TTT_BOARD_AREA][TTT_BOARD_AREA];	
				//Loop right through positions for 
				//winning condition number of times.
				for (int k = 0; k < WIN_COND_TTT; k++){
					//Records exact position checked.
					int position = i + k;
					//Records all positions checked.
					winPositionsTTT[position][j] = 1;
					//If player has an X or O in a position it is recorded in
					//their player positions as a 1 for that position.
					//Score then adds these vales together for a winning 
					//condition number of iterations. If they have a that
					//position it adds 1 if not it adds 0.
					score = score + playerPositionAcross[position][j];	
					//Checks if the sum of score is equal to winning condition.
					if (score == WIN_COND_TTT){
						//If it is won is set to true
						won = true;
						//Records the winning position from checked positions.
						// m_winPositionsTTT = winPositionsTTT;
						setWinningPosition(winPositionsTTT);
					}
				}
			}
		}
		return won;
	}
			
	/**
	* Check if the players positions across the board are in a winning position.
	* @param playerPositions an integer array, check if in a winning combination.
	* @see m_checkTTTWin; called by.
	* @return won; if a player has a wining position returns true else false.
	*/
	private static boolean m_winDown(int [][] playerPositionDown){	
		//Sets won condition to false unless win condition is met.
		boolean won = false;	
		//Loop through vertical axis of board.
		for (int i = 0; i < TTT_BOARD_AREA; i++){	
			//Loop through horizontal axis of board minus winning condition number 
			//of times, as these will be used by and inner loop.
			for (int j = 0; j < TTT_BOARD_AREA - WIN_COND_TTT + 1; j++){
				//Stores how many positions in a row a player has.
				int score = 0;
				//Initialise variable holding checked positions.
				int[][] winPositionsTTT = new int [TTT_BOARD_AREA][TTT_BOARD_AREA];	
				//Loop right through positions for 
				//winning condition number of times.
				for (int k = 0; k < WIN_COND_TTT; k++){		
					//Records exact position checked.
					int position = j + k;	
					//Records all positions checked.
					winPositionsTTT[i][position] = 1;
					//If player has an X or O in a position it is recorded in
					//their player positions as a 1 for that position.
					//Score then adds these vales together for a winning 
					//condition number of iterations. If they have a that
					//position it adds 1 if not it adds 0.
					score = score + playerPositionDown[i][position];
					//Checks if the sum of score is equal to winning condition.
					if (score == WIN_COND_TTT){
						//If it is won is set to true
						won = true;
						//Records the winning position from checked positions.
						// m_winPositionsTTT = winPositionsTTT;
						setWinningPosition(winPositionsTTT);
					}
				}
			}
		}
		return won;
	}
	
	/**
	* Check if the players positions across the board are in a winning position.
	* @param playerPositions an integer array, check if in a winning combination.	
	* @see m_checkTTTWin; called by.
	* @return won; if a player has a wining position returns true else false.
	*/
	private static boolean m_winDiagRight(int [][] playerPositionDR){
		//Sets won condition to false unless win condition is met.
		boolean won = false;
		//Loop through horizontal axis of board minus winning condition number 
		//of times, as these will be used by and inner loop.
		for (int i = 0; i < TTT_BOARD_AREA - WIN_COND_TTT + 1; i++){
			//Loop through vertical axis of board minus winning condition number 
			//of times, as these will be used by and inner loop.
			for (int j = 0; j < TTT_BOARD_AREA - WIN_COND_TTT + 1; j++){
				//Stores how many positions in a row a player has.
				int score = 0;
				//Initialise variable holding checked positions.
				int[][] winPositionsTTT = new int [TTT_BOARD_AREA][TTT_BOARD_AREA];
				//Loop right through positions for 
				//winning condition number of times.
				for (int k = 0; k < WIN_COND_TTT; k++){
					//Records exact horizontal position checked.
					int positionAcross = i + k;
					//Records exact vertical position checked.
					int positionDown = j + k;
					//Records all positions checked.
					winPositionsTTT[positionAcross][positionDown] = 1;
					//If player has an X or O in a position it is recorded in
					//their player positions as a 1 for that position.
					//Score then adds these vales together for a winning 
					//condition number of iterations. If they have a that
					//position it adds 1 if not it adds 0.
					score = score + playerPositionDR[positionAcross][positionDown];
					//Checks if the sum of score is equal to winning condition.
					if (score == WIN_COND_TTT){
						//If it is won is set to true
						won = true;
						//Records the winning position from checked positions.
						m_winPositionsTTT = winPositionsTTT;
						setWinningPosition(winPositionsTTT);
					}
				}
			}
		}
		return won;
	}
	
	/**
	* Check if the players positions across the board are in a winning position.
	* @param playerPositions an integer array, check if in a winning combination.	
	* @see m_checkTTTWin; called by.
	* @return won; if a player has a wining position returns true else false.
	*/
	private static boolean m_winDiagLeft(int [][] playerPositionDL){
		//Sets won condition to false unless win condition is met.
		boolean won = false;
		//Loop through horizontal axis of board minus winning condition number 
		//of times, as these will be used by and inner loop.
		for (int i = WIN_COND_TTT + 1; i < TTT_BOARD_AREA; i++){
			//Loop through vertical axis of board minus winning condition number 
			//of times, as these will be used by and inner loop.
			for (int j = 0; j < TTT_BOARD_AREA - WIN_COND_TTT + 1; j++){
				//Stores how many positions in a row a player has.
				int score = 0;
				//Initialise variable holding checked positions.
				int[][] winPositionsTTT = new int [TTT_BOARD_AREA][TTT_BOARD_AREA];
				//Loop right through positions for 
				//winning condition number of times.
				for (int k = 0; k < WIN_COND_TTT; k++){
					//Records exact horizontal position checked.
					int positionAcross = i - k;
					//Records exact vertical position checked.
					int positionDown = i + k - WIN_COND_TTT;
					//Records all positions checked.
					winPositionsTTT[positionAcross][positionDown] = 1;
					//If player has an X or O in a position it is recorded in
					//their player positions as a 1 for that position.
					//Score then adds these vales together for a winning 
					//condition number of iterations. If they have a that
					//position it adds 1 if not it adds 0.
					score = score + playerPositionDL[positionAcross][positionDown];
					//Checks if the sum of score is equal to winning condition.
					if (score == WIN_COND_TTT){
						//If it is won is set to true
						won = true;
						//Records the winning position from checked positions.
						// m_winPositionsTTT = winPositionsTTT;
						setWinningPosition(winPositionsTTT);
					}
				}
			}
		}
		return won;
	}
			
	/**
	* Checks if a player has won a game of Snakes and Ladders.
	* @param player an int; records which player has made a move.
	* @param playerPositions an int; check if in a winning position	.
	* @see SnakesAndLaddersGui.getMove(); calls if player has not won.
	* @see CalculateResults.getWinningPlayer(); calls if player has won.
	*/
	/*public void m_checkSALWin (PlayerSAL player){
		if (player.getPlayerPosition = WIN_CONDITION_SAL) {
			CalculateResults.getWinningPlayer(player);
		}else {
			SnakesAndLadders.m_rollDice(player);
		}
	}*/
}
