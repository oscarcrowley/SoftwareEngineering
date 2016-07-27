package A3;

/**
 * @file DecideOrder.java
 * @author Avishek Siris
 * @date 26 Nov 2014
 * @see SnakesAndLadders.java; called by to decide players turn
 * 
 * @Brief Class to decide players turn
 * 
 */

import java.util.ArrayList;

public class DecideOrder {
	private static ArrayList<String> playerOrder;
	private static int [] playersOrderResults; 
	private static int numberOfPlayers;
	private static boolean ordersDecided = false;

	/**
	* Method to decide order of players
    * @see SnakesAndLadders(); called by
    * @param int players, number of players
    * @param ArrayList<PlayerSAL> playerList, list of players
	*/	
	public static void decideOrder(int players, ArrayList<PlayerSAL> playerList){		
		numberOfPlayers = players;
		playersOrderResults = new int [numberOfPlayers]; 
		playerOrder = new ArrayList<String>();
				
		for(int i = 0; i < numberOfPlayers; i++){
			playersOrderResults[i] = Die.generate();
		}
			
		for(int i = 0; i < numberOfPlayers; i++){
			playerOrder.add(playerList.get(i).getName());
		}	
		
		if (numberOfPlayers == 4){
			sortOrder(0, 4);
		}else if (numberOfPlayers == 3){
			sortOrder(0, 3);
		} else {
			sortOrder(0, 2);
		}		
						
		while(!ordersDecided){
			reRollsCheck();
		}			
	}	
	
	/**
	* Method to reroll and decide order between tied players
    * @see decideOrder(); called by
	*/		
	private static void reRollsCheck() {
		for(int i = 0; i < numberOfPlayers-1; i++){
			if (playersOrderResults[i] == playersOrderResults[i+1]){
				if(numberOfPlayers > 2 && i == 0 && playersOrderResults[i] == playersOrderResults[i+2]){
					if(numberOfPlayers == 4 && i == 0 && playersOrderResults[i] == playersOrderResults[i+3]){
						reRollAll();	
						sortOrder(0, 4);
					} else if(numberOfPlayers == 4 && i == 0){
						playersOrderResults[3] = 10;
						reRoll3(0 ,1 ,2);
						sortOrder(0, 3);
					} else if(numberOfPlayers == 4 && i == 0){
						playersOrderResults[0] = 7;
						reRoll3(1, 2, 3);
						sortOrder(1, 4);
					}
				} else if(numberOfPlayers == 4 && i == 0 && playersOrderResults[i] == playersOrderResults[i+3]){
					playersOrderResults[2] = 9;
					reRoll3(0, 1, 3);
					sortOrder3(0, 1, 3);						
				} else {
					if(i == 0){
						reRoll2(0, 1);
						sortOrder2(0, 1);
					} else if(i == 1){
						playersOrderResults[0] = 7;
						if (numberOfPlayers == 4){
							playersOrderResults[3] = 10;
						}
						reRoll2(1, 2);
						sortOrder2(1, 2);
					} else if (numberOfPlayers == 4){
						playersOrderResults[0] = 7;
						playersOrderResults[1] = 8;
						reRoll2(2, 3);
						sortOrder2(2, 3);
					}
				}
			} else if (numberOfPlayers > 2 && i == 0 && playersOrderResults[i] == playersOrderResults[i+2]){
				if(numberOfPlayers == 4 && i == 0 && playersOrderResults[i] == playersOrderResults[i+3]){
					playersOrderResults[1] = 8;
					reRoll3(0, 2, 3);	
					sortOrder3(0, 2, 3);
				} else if(i == 0){
					reRoll2(0, 2);
					sortOrder2(0, 2);
				} else if (numberOfPlayers == 4 && i == 0){
					playersOrderResults[0] = 7;
					playersOrderResults[2] = 9;
					reRoll2(1, 3);
					sortOrder2(1, 3);
				}
			} else if(numberOfPlayers == 4 && i == 0 && playersOrderResults[i] == playersOrderResults[i+3]){
				reRoll2(0, 3);
				sortOrder2(0, 3);					
			} else {
				if(i == (numberOfPlayers-2)){
				ordersDecided = true;
				}
			}
		}		
	}
	
	/**
	* Method to sort order for all 4 players
    * @see reRollsCheck(); called by
    * @param int m, start of range
    * @param int n, end of range
	*/		
	private static void sortOrder(int m, int n) {
		int temp = 0;		
		String temp2 = "";		
		for(int i = m; i < n; i++){
			for(int j = (m+1); j < n; j++){
				if(playersOrderResults[j-1] < playersOrderResults[j]){
					temp = playersOrderResults[j-1];
					playersOrderResults[j-1] = playersOrderResults[j];
					playersOrderResults[j] = temp;
					temp2 = playerOrder.get(j-1);
					playerOrder.set((j-1), playerOrder.get(j));
					playerOrder.set((j), temp2);
				}
			}
		}		
	}
	
	/**
	* Method to sort order for 3 players
    * @see reRollsCheck(); called by
    * @param int m, player number
    * @param int n, player number
    * @param int o, player number
	*/	
	private static void sortOrder3(int m, int n, int o) {
		int temp = 0;		
		String temp2 = "";	
		if(playersOrderResults[m] < playersOrderResults[n]){
			temp = playersOrderResults[m];
			playersOrderResults[m] = playersOrderResults[n];
			playersOrderResults[n] = temp;
			temp2 = playerOrder.get(m);
			playerOrder.set((m), playerOrder.get(n));
			playerOrder.set((n), temp2);
		}		
		if(playersOrderResults[m] < playersOrderResults[o]){
			temp = playersOrderResults[m];
			playersOrderResults[m] = playersOrderResults[o];
			playersOrderResults[o] = temp;
			temp2 = playerOrder.get(m);
			playerOrder.set((m), playerOrder.get(o));
			playerOrder.set((o), temp2);
		}	
		if(playersOrderResults[n] < playersOrderResults[o]){
			temp = playersOrderResults[n];
			playersOrderResults[n] = playersOrderResults[o];
			playersOrderResults[o] = temp;
			temp2 = playerOrder.get(n);
			playerOrder.set((n), playerOrder.get(o));
			playerOrder.set((o), temp2);
		}		
	}
	
	/**
	* Method to sort order for 2 players
    * @see reRollsCheck(); called by
    * @param int m, player number
    * @param int n, player number
	*/	
	private static void sortOrder2(int m, int n) {	
		int temp = 0;		
		String temp2 = "";	
		if(playersOrderResults[m] < playersOrderResults[n]){
			temp = playersOrderResults[m];
			playersOrderResults[m] = playersOrderResults[n];
			playersOrderResults[n] = temp;
			temp2 = playerOrder.get(m);
			playerOrder.set((m), playerOrder.get(n));
			playerOrder.set((n), temp2);
		}
		if (m == 0 && n == 1 && playersOrderResults[m] == playersOrderResults[n]){
			reRoll2(0, 1);
			sortOrder2(0, 1);
		}
		if (m == 0 && n == 2 && playersOrderResults[m] == playersOrderResults[n]){
			reRoll2(0, 2);
			sortOrder2(0, 2);
		}
		if (m == 0 && n == 3 && playersOrderResults[m] == playersOrderResults[n]){
			reRoll2(0, 3);
			sortOrder2(0, 3);
		}
	}

	/**
	* Method to reroll all 4 players
    * @see reRollsCheck(); called by
	*/	
	private static void reRollAll() {
		for(int i = 0; i < numberOfPlayers; i++){
			playersOrderResults[i] = Die.generate();
		}		
	}
	
	/**
	* Method to reroll 3 players
    * @see reRollsCheck(); called by
    * @param int i, player number
    * @param int j, player number
    * @param int k, player number
	*/	
	private static void reRoll3(int i, int j, int k) {
		playersOrderResults[i] = Die.generate();
		playersOrderResults[j] = Die.generate();
		playersOrderResults[k] = Die.generate();
	}
	
	/**
	* Method to reroll 2 players
    * @see reRollsCheck(), sortOrder2(); called by
    * @param int i, player number
    * @param int j, player number
	*/	
	private static void reRoll2(int i, int j) {
		playersOrderResults[i] = Die.generate();
		playersOrderResults[j] = Die.generate();	
	}
	
	/**
	* Method to return the decided order
    * @see SnakesAndLadders(); called by
    * @return ArrayList<String> playerOrder
	*/	
	public static ArrayList<String> getPlayerOrder(){
		return playerOrder;		
	}
}
