package A3;

/**
* @file SnakesAndLadders.java
* @author Avishek Siris
* @date 26 Nov 2014
* @see SALGUI.java; calls to display gui
* @see DecideOrder.java; calls to decide order of players turn
* @see Die.java; calls to genrate random roll
* 
* @Brief Class to run Snakes and Ladders Game
* 
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;

public class SnakesAndLadders {

	private Scanner in = new Scanner(System.in);
	private int numberOfPlayers;
	private ArrayList<PlayerSAL> playerList;
	private ArrayList<String> playerOrder;
	private int[] oPLIndex;
	private int currentPlayer = 0;
	private String currentPiece;
	private int currentPosition;
	private int snakeNumber;
	private int ladderNumber;
	private int dieRoll = 0;
	private PlayerSAL winner;
	private boolean win = false;
	private int snakeHead;
	private int snakeTail;
	private int ladderBottom;
	private int ladderTop;
	private ArrayList<Integer> pointsUsed;
	private ArrayList<SnakePoints> sPointsList;
	private ArrayList<LadderPoints> lPointsList;
	private boolean pointClear = false;
	private Random rnd = new Random();
	private SALGUI salGui;
	private JButton rollDieButton;
	private boolean roll = false;
	private boolean specialPosition = false;

	/**
	* Initialise Class 
	*/	
	public static void main(String[] args){
		SnakesAndLadders game = new SnakesAndLadders();
	}
	
	/**
	* Constructor of class 
	*/	
	public SnakesAndLadders(){ 				
		//Method called which asks number of players
		getNumberOfPlayers();
		
		//Sets next line for later inputs
		in.nextLine();

		//Initialise Arraylists
		playerList = new ArrayList<PlayerSAL>();
		playerOrder = new ArrayList<String>();

		//Method called to ask for player info
		setPlayersInfo(numberOfPlayers);
		
		//Method called to ask user for number of snakes and ladders 
		getSnakesLaddersNum();		
		
		//Initialise ArrayLists
		pointsUsed = new ArrayList<Integer>();
		sPointsList = new ArrayList<SnakePoints>();
		lPointsList = new ArrayList<LadderPoints>();
		
		//Method called to create the points for snakes and ladders
		createSLPoints();

		//Method called to decide order
		decideOrder();



		//List for the index of playerList in the order of playerOrder
		oPLIndex = new int[numberOfPlayers];				
		for(int i = 0; i < numberOfPlayers; i++){
			for(int j = 0; j < numberOfPlayers; j++){
				if (playerOrder.get(i).equals(playerList.get(j).getName())){
					oPLIndex[i] = j;
				}				
			}			
		}		
		
		//Method called to create board
		createBoard();
		
		//Method called to display info in the gui
		displayVisuals();
		
		//Method called to start game
		startGame();		
	}

	/**
	* Method to create the Gui
    * @see SnakesAndLadders(); called by.
	*/	
	private void createBoard() {
		//Initialises Gui
		salGui = new SALGUI (playerList, sPointsList, lPointsList);
		
		//Gets roll button from SALGUI 
		rollDieButton = salGui.getRollButton();

	}
	
	/**
	* Method to get number of players
    * @see SnakesAndLadders(); called by.
	*/	
	private void getNumberOfPlayers() {
		System.out.println("Please enter the number of players: ");
		int playersNumber = in.nextInt();
		numberOfPlayers = playersNumber;
	}
	
	/**
	* Method to get players info
    * @see SnakesAndLadders(); called by.
	*/	
	private void setPlayersInfo(int numberOfPlayers) {
		String playerName;
		String playerColour;
		int playerPosition = 1;
		
		//For loop which asks for players info depending on number of players and adds to arraylist
		for(int i = 1; i <= numberOfPlayers; i++){
			System.out.println("Please enter Player " + i + " Name: ");
			playerName = in.nextLine();
			System.out.println("Please enter Player " + i + " Colour: ");
			playerColour = in.nextLine();		
			PlayerSAL player = new PlayerSAL(playerName, playerColour, playerPosition);
			playerList.add(player);
		}		
	}
	
	/**
	* Method to get number of snakes and ladders
    * @see SnakesAndLadders(); called by.
	*/	
	private void getSnakesLaddersNum(){
		//Asks and assigns the number of snakes and ladders to variables
		System.out.println("Please enter the number of snakes for the game: ");
		snakeNumber = in.nextInt();
		System.out.println("Please enter the number of ladders for the game: ");
		ladderNumber= in.nextInt();
		in.nextLine();
	}
	
	/**
	* Method to create the points of snakes and ladders
    * @see SnakesAndLadders(); called by.
	*/	
	private void createSLPoints() {
		//For loop to generate distinct snake points
		for (int i = 0; i < snakeNumber; i++){
			snakeHead = rnd.nextInt((99 - 2) + 1) + 2;
			snakeTail = rnd.nextInt((99 - 2) + 1) + 2;			
			while(!pointClear){
				snakeHeadTailCheck();
			}
			pointsUsed.add(snakeHead);
			pointsUsed.add(snakeTail);
			SnakePoints sPoints = new SnakePoints(snakeHead, snakeTail);	
			sPointsList.add(sPoints);
			pointClear = false;
		}
		//For loop to generate distinct ladder points
		for (int i = 0; i < ladderNumber; i++){
			ladderTop = rnd.nextInt((99 - 2) + 1) + 2;
			ladderBottom = rnd.nextInt((99 - 2) + 1) + 2;			
			while(!pointClear){
				ladderTopBottomCheck();
			}
			pointsUsed.add(ladderTop);
			pointsUsed.add(ladderBottom);
			LadderPoints lPoints = new LadderPoints(ladderTop, ladderBottom);	
			lPointsList.add(lPoints);
			pointClear = false;
		}
	}
	
	/**
	* Method checks if points are already used
	* @param String end, either the point is the top or bottom
	* @param int point, the point in the board
	* @param String type, either snake or ladder
    * @see snakeHeadTailCheck(), ladderTopBottomCheck(); called by.
	*/	
	private void pointsCheck(String end, int point, String type){
		//For loop to check if a given point is already used
		for (int j = 0; j < pointsUsed.size(); j++){
			if (pointsUsed.get(j) == point){
				if (end.equals("Top")){
					if (type.equals("Snake")){
						snakeHead = rnd.nextInt((99 - 2) + 1) + 2;
						pointsCheck("Top", snakeHead, "Snake");
					} else {
						ladderTop = rnd.nextInt((99 - 2) + 1) + 2;
						pointsCheck("Top", ladderTop, "Ladder");
					}

				} else {
					if (type.equals("Snake")){
						snakeTail = rnd.nextInt((99 - 2) + 1) + 2;
						pointsCheck("Bottom", snakeTail, "Snake");
					} else {
						ladderBottom = rnd.nextInt((99 - 2) + 1) + 2;
						pointsCheck("Bottom", ladderBottom, "Ladder");
					}

				}				
			}
		}
	}	
	
	/**
	* Method to check points of snake
    * @see createSLPoints(); called by.
	*/	
	private void snakeHeadTailCheck(){
		//While loop to make sure point of snake's tail is lower than head
		while (snakeHead <= snakeTail){
			snakeHead = rnd.nextInt((99 - 2) + 1) + 2;
			pointsCheck("Top", snakeHead, "Snake");
			snakeTail = rnd.nextInt((99 - 2) + 1) + 2;
			pointsCheck("Bottom", snakeTail, "Snake");
		}	
		
		//Checks points
		pointsCheck("Top", snakeHead, "Snake");
		pointsCheck("Bottom", snakeTail, "Snake");
		
		//boolean true if the points are suitable
		pointClear = true;
	}
	
	/**
	* Method to check points of ladder
    * @see createSLPoints(); called by.
	*/	
	private void ladderTopBottomCheck(){
		//While loop to make sure point of ladder's bottom is lower than top
		while (ladderTop <= ladderBottom){
			ladderTop = rnd.nextInt((99 - 2) + 1) + 2;
			pointsCheck("Top", ladderTop, "Ladder");
			ladderBottom = rnd.nextInt((99 - 2) + 1) + 2;
			pointsCheck("Bottom", ladderBottom, "Ladder");
		}	
		
		//Checks points
		pointsCheck("Top", ladderTop, "Ladder");
		pointsCheck("Bottom", ladderBottom, "Ladder");
		
		//boolean true if the points are suitable
		pointClear = true;
	}
	
	/**
	* Method to decide order of players
    * @see SnakesAndLadders(); called by.
	*/	
	private void decideOrder(){
		//Calls method in DecideOrder class
		DecideOrder.decideOrder(numberOfPlayers, playerList);
		
		//Assigns arraylist with order decided
		playerOrder = DecideOrder.getPlayerOrder();
	}				

	/**
	* Method to display info in gui
    * @see SnakesAndLadders(), startGame(), checkWinner; called by.
	*/
	private void displayVisuals() {		
		String playerName = playerList.get(0).getName();
		String playerPiece = playerList.get(0).getColour();
		int playerPosition = playerList.get(0).getPlayerPosition();
		
		//Displays player 1 info
		salGui.displayPlayerName(playerName, 1);
		salGui.displayPlayerPiece(playerPiece, 1);
		salGui.displayPlayerPosition(playerPosition, 1);
		
		//Displays player 2 info
		playerName = playerList.get(1).getName();
		playerPiece = playerList.get(1).getColour();
		playerPosition = playerList.get(1).getPlayerPosition();
		salGui.displayPlayerName(playerName, 2);
		salGui.displayPlayerPiece(playerPiece, 2);
		salGui.displayPlayerPosition(playerPosition, 2);
		
		//Displays player 3 info
		if (numberOfPlayers > 2){
			playerName = playerList.get(2).getName();
			playerPiece = playerList.get(2).getColour();
			playerPosition = playerList.get(2).getPlayerPosition();
			salGui.displayPlayerName(playerName, 3);
			salGui.displayPlayerPiece(playerPiece, 3);
			salGui.displayPlayerPosition(playerPosition, 3);
		}
		
		//Displays player 4 info
		if (numberOfPlayers == 4){
			playerName = playerList.get(3).getName();
			playerPiece = playerList.get(3).getColour();
			playerPosition = playerList.get(3).getPlayerPosition();
			salGui.displayPlayerName(playerName, 4);
			salGui.displayPlayerPiece(playerPiece, 4);
			salGui.displayPlayerPosition(playerPosition, 4);
		}
		
		//Displays the players turn and die rolled
		salGui.displayPlayersTurn((oPLIndex[currentPlayer] + 1));
		salGui.displayDieRolled(dieRoll);
	}
	
	/**
	* Method to start and play game
    * @see SnakesAndLadders(); called by.
	*/
	public void startGame() {
		//Setup for game		
		currentPiece = playerList.get(oPLIndex[currentPlayer]).getColour();
		currentPosition = playerList.get(oPLIndex[currentPlayer]).getPlayerPosition();
		
		displayVisuals();
		
		//Listener for roll button
		rollDieButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				roll = true;
			}
		}); 

		//Game loop
		while(!win){						
			while(!roll){				
				Thread.yield();
			}
			roll = false;
			makeTurn();
			checkWinner();			
		}
		
		//Stops time
		salGui.stopTime();
		
		//Gets winner
		winner = playerList.get(oPLIndex[currentPlayer]);
		
		//Finish game
		endGame();
	}

	
	/**
	* Method to take turn
    * @see startGame(); called by.
	*/
	private void makeTurn(){
		//Calls Die class to generate a random roll
		dieRoll = Die.generate();
		currentPosition += dieRoll;
		
		//Moves the piece in gui
		movePiece();		
		
		//Check if landed on snake
		for(int i = 0; i < sPointsList.size(); i++){
			if (currentPosition == sPointsList.get(i).getSnakeHead()){
				currentPosition = sPointsList.get(i).getSnakeTail();
				specialPosition = true;
				movePiece();		
				specialPosition = false;
			}			
		}	
		
		//Check if landed on ladder
		for(int i = 0; i < lPointsList.size(); i++){
			if (currentPosition == lPointsList.get(i).getLadderBottom()){
				currentPosition = lPointsList.get(i).getLadderTop();
				specialPosition = true;
				movePiece();
				specialPosition = false;
			}		
		}		
		
		playerList.get(oPLIndex[currentPlayer]).setPlayerPosition(currentPosition);			
	}

	/**
	* Method to move piece in gui
    * @see makeTurn(); called by.
	*/
	private void movePiece() {
		currentPiece = playerList.get(oPLIndex[currentPlayer]).getColour();
		
		//Moves the turn players piece
		if (currentPosition < 100){
			salGui.displayMoveAnimation(currentPiece, currentPosition, specialPosition);
		}
	}
	
	
	/**
	* Method to check for winner
    * @see startGame(); called by.
	*/
	private void checkWinner(){
		//Checks if there is a winner else next players turn
		if (currentPosition > 99){
			win = true;			
		} else {
			if (currentPlayer == numberOfPlayers-1){
				currentPlayer = 0;
			} else {
				currentPlayer++;
			}
			displayVisuals();
			currentPosition = playerList.get(oPLIndex[currentPlayer]).getPlayerPosition();
			for (PlayerSAL players : playerList){
				System.out.println(players);
			}
		}
	}
	
	/**
	* Method to finish game
    * @see startGame(); called by.
	*/
	private void endGame(){		
		ResultsGUI.m_displayResults(playerList.get(oPLIndex[currentPlayer] + 1).getName(), salGui.getTime());		
	}
}
