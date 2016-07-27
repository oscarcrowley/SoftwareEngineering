package A3;

/**
* @file SALGUI.java
* @author Avishek Siris
* @date 03 Dec 2014
* @see Clock.java
* @see Board.java
* 
* @Brief Gui class of Snakes and Ladders
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SALGUI {
	
	private int currentPosition;
	private int finalPosition;
	private int p1Position = 1;
	private int p2Position = 1;
	private int p3Position = 1;
	private int p4Position = 1;
	private String currentPiece;
	private int currentX = 0;
	private int currentY = 0;
	private int pieceX = 0;
	private int pieceY = 0;		
	private int dieRolled;
	private JFrame gameBoard;
	private JPanel player1Panel;
	private JLabel player1Name;
	private JLabel player1Piece;
	private JLabel player1Position;
	private JPanel player2Panel;
	private JLabel player2Name;
	private JLabel player2Piece;
	private JLabel player2Position;
	private JPanel player3Panel;
	private JLabel player3Name;
	private JLabel player3Piece;
	private JLabel player3Position;
	private JPanel player4Panel;
	private JLabel player4Name;
	private JLabel player4Piece;
	private JLabel player4Position;
	private JPanel infoPanel;
	private JLabel playersTurnLabel;
	private JLabel dieRolledLabel;
	private JLabel redLabel;
	private JLabel blueLabel;
	private JLabel yellowLabel;
	private JLabel blackLabel;
	private JButton rollButton;
	private JLabel timeLabel;
	private boolean finishMove = false;
	private ArrayList<PlayerSAL> playersList;
	private Clock clock;
	private Timer timer;			
	private URL redPiece = getClass().getResource("image/Red Piece.png");
	private URL bluePiece = getClass().getResource("image/Blue Piece.png");
	private URL yellowPiece = getClass().getResource("image/Yellow Piece.png");
	private URL blackPiece = getClass().getResource("image/Black Piece.png");
	private URL rollButtonImage = getClass().getResource("image/Roll Die Button.png");
	
	/**
	* Constructor of class 
	* @param ArrayList<PlayerSAL> playerList
	* @param ArrayList<SnakePoints> sPointsList
	* @param ArrayList<LadderPoints> lPointsList
	*/	
	public SALGUI(ArrayList<PlayerSAL> playerList, ArrayList<SnakePoints> sPointsList, ArrayList<LadderPoints> lPointsList){
		playersList = playerList;
		displayBoard(sPointsList, lPointsList);
		clock = new Clock();
		clock.setGameStartTime();
		displayTime();
	}	
	
	/**
	 * Method to display gui
	 * @param ArrayList<SnakePoints> sPointsList
	 * @param ArrayList<LadderPoints> lPointsList
	 */	
	public void displayBoard(ArrayList<SnakePoints> sPointsList, ArrayList<LadderPoints> lPointsList){
		int height = 1000;
		int width = 1000;
		
		gameBoard = new JFrame("Snakes and Ladders");
		gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameBoard.setLayout(null);
		
		// Player 1
		player1Panel = new JPanel();
		player1Panel.setLayout(null);
		player1Panel.setBounds(10, 10, 250, 75);
		gameBoard.add(player1Panel);			
		player1Name = new JLabel("");
		player1Name.setLayout(null);
		player1Name.setBounds(0, 0, 225, 15);
		player1Panel.add(player1Name);		
		player1Piece = new JLabel("");
		player1Piece.setLayout(null);
		player1Piece.setBounds(0, 20, 150, 15);
		player1Panel.add(player1Piece);
		player1Position= new JLabel("");
		player1Position.setLayout(null);
		player1Position.setBounds(0, 40, 100, 15);
		player1Panel.add(player1Position);
		
		// Player 2
		player2Panel = new JPanel();
		player2Panel.setLayout(null);
		player2Panel.setBounds(600, 10, 250, 75);
		gameBoard.add(player2Panel);			
		player2Name = new JLabel("");
		player2Name.setLayout(null);
		player2Name.setBounds(0, 0, 225, 15);
		player2Panel.add(player2Name);			
		player2Piece = new JLabel("");
		player2Piece.setLayout(null);
		player2Piece.setBounds(0, 20, 150, 15);
		player2Panel.add(player2Piece);
		player2Position= new JLabel("");
		player2Position.setLayout(null);
		player2Position.setBounds(0, 40, 100, 15);
		player2Panel.add(player2Position);
		
		if (playersList.size() > 2){
			// Player 3
			player3Panel = new JPanel();
			player3Panel.setLayout(null);
			player3Panel.setBounds(10, 900, 250, 75);
			gameBoard.add(player3Panel);			
			player3Name = new JLabel("");
			player3Name.setLayout(null);
			player3Name.setBounds(0, 0, 225, 15);
			player3Panel.add(player3Name);			
			player3Piece = new JLabel("");
			player3Piece.setLayout(null);
			player3Piece.setBounds(0, 20, 150, 15);
			player3Panel.add(player3Piece);
			player3Position= new JLabel("");
			player3Position.setLayout(null);
			player3Position.setBounds(0, 40, 100, 15);
			player3Panel.add(player3Position);
		}
		
		if (playersList.size() == 4){
			// Player 3
			player4Panel = new JPanel();
			player4Panel.setLayout(null);
			player4Panel.setBounds(600, 900, 250, 75);
			gameBoard.add(player4Panel);			
			player4Name = new JLabel("");
			player4Name.setLayout(null);
			player4Name.setBounds(0, 0, 225, 15);
			player4Panel.add(player4Name);			
			player4Piece = new JLabel("");
			player4Piece.setLayout(null);
			player4Piece.setBounds(0, 20, 150, 15);
			player4Panel.add(player4Piece);
			player4Position= new JLabel("");
			player4Position.setLayout(null);
			player4Position.setBounds(0, 40, 100, 15);
			player4Panel.add(player4Position);
		}
		
		infoPanel = new JPanel();
		infoPanel.setLayout(null);
		infoPanel.setBounds(300, 10, 250, 85);
		gameBoard.add(infoPanel);			
		playersTurnLabel = new JLabel("Players Turn: 1");
		playersTurnLabel.setLayout(null);
		playersTurnLabel.setBounds(0, 0, 225, 15);
		infoPanel.add(playersTurnLabel);		
		dieRolledLabel = new JLabel("Die Roll: 0");
		dieRolledLabel.setLayout(null);
		dieRolledLabel.setBounds(0, 20, 225, 15);		
		infoPanel.add(dieRolledLabel);
		timeLabel = new JLabel("Time: ");
		timeLabel.setLayout(null);
		timeLabel.setBounds(0, 40, 225, 15);
		infoPanel.add(timeLabel);
		
	
		for (int i = 0; i < playersList.size(); i++){
			String colour = playersList.get(i).getColour();			
			if (colour.equals("Red")){
				redLabel = new JLabel("");
				redLabel.setIcon(new ImageIcon(redPiece));
				redLabel.setBounds(150, 766, 40, 40);
				gameBoard.add(redLabel);
			}			
		}	
		for (int i = 0; i < playersList.size(); i++){
			String colour = playersList.get(i).getColour();		
			
			if (colour.equals("Blue")){
				blueLabel = new JLabel("");
				blueLabel.setIcon(new ImageIcon(bluePiece));
				blueLabel.setBounds(150, 776, 40, 40);
				gameBoard.add(blueLabel);
			}
		}
		for (int i = 0; i < playersList.size(); i++){
			String colour = playersList.get(i).getColour();		
			if (colour.equals("Yellow")){
				yellowLabel = new JLabel("");
				yellowLabel.setIcon(new ImageIcon(yellowPiece));
				yellowLabel.setBounds(150, 786, 40, 40);
				gameBoard.add(yellowLabel);
			}
		}
		for (int i = 0; i < playersList.size(); i++){
			String colour = playersList.get(i).getColour();		
			if (colour.equals("Black")){
				blackLabel = new JLabel("");
				blackLabel.setIcon(new ImageIcon(blackPiece));
				blackLabel.setBounds(150, 796, 40, 40);
				gameBoard.add(blackLabel);
			}
		}
		
		rollButton = new JButton("");
		rollButton.setIcon(new ImageIcon(rollButtonImage));
		rollButton.setBounds(865, 490, 100, 50);
		gameBoard.add(rollButton);
								
		Board board = new Board(sPointsList, lPointsList);
		board.setLayout(null);
		board.setBounds(136, 132, 756, 728);	
		gameBoard.add(board);		
		
		gameBoard.setSize(height, width);
		gameBoard.setVisible(true);
		
	}	
	
	
	/**
	 * Method to update player name
	 * @param String playerName
	 * @param int player
	 */	
	public void displayPlayerName(String playerName, int player){
		if (player == 1){
			player1Name.setText("Player 1: " + playerName);
		} else if (player == 2){
			player2Name.setText("Player 2: " + playerName);		
		} else if (player == 3){
			player3Name.setText("Player 3: " + playerName);	
		} else {
			player4Name.setText("Player 4: " + playerName);			
		}
	}
	
	/**
	 * Method to update player piece
	 * @param String playerPiece
	 * @param int player
	 */	
	public void displayPlayerPiece(String playerPiece, int player){
		if (player == 1){
			player1Piece.setText("Piece: " + playerPiece);			
		} else if (player == 2){
			player2Piece.setText("Piece: " + playerPiece);			
		} else if (player == 3){
			player3Piece.setText("Piece: " + playerPiece);		
		} else {
			player4Piece.setText("Piece: " + playerPiece);			
		}
	}
	
	/**
	 * Method to update player position
	 * @param int playerPosition
	 * @param int player
	 */	
	public void displayPlayerPosition(int playerPosition, int player){
		if (player == 1){
			player1Position.setText("Position: " + playerPosition);			
		} else if (player == 2){
			player2Position.setText("Position: " + playerPosition);			
		} else if (player == 3){
			player3Position.setText("Position: " + playerPosition);			
		} else {
			player4Position.setText("Position: " + playerPosition);		
		}
	}	
	
	/**
	 * Method to update player turn
	 * @param int player
	 */	
	public void displayPlayersTurn(int player){
		playersTurnLabel.setText("Players Turn: " + player);		
	}
	
	/**
	 * Method to update die rolled
	 * @param int roll
	 */	
	public void displayDieRolled(int roll){
		dieRolled = roll;
		dieRolledLabel.setText("Die Roll: " + dieRolled);		
	}
	
	/**
	 * Method to update time
	 */	
	private void displayTime() {	
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				timeLabel.setText("Time: " + clock.getGameTime());
			}
		};
		timer = new Timer(1000 ,taskPerformer);
		timer.setRepeats(true);
		timer.start();			
	}
	
	/**
	 * Method to return the current time
	 * @return Clock clock.getGameTime()
	 */	
	public String getTime(){
		return clock.getGameTime();
	}
	
	/**
	 * Method to animate piece movement
	 * @param String colour
	 * @param int position
	 * @param boolean specialPosition
	 */	
	public void displayMoveAnimation(String colour, int position, boolean specialPosition){
		currentPiece = colour;
		finalPosition = position;			
				
		if (currentPiece.equals("Red")){	
			if (specialPosition){
				p1Position = finalPosition;
				currentPosition = finalPosition;
				getXCoordinate();		
				getYCoordinate();
				redLabel.setBounds(pieceX, pieceY, 40, 40);
			} else {
				for (int i = p1Position; i < finalPosition; i++){
					p1Position++;
					currentPosition = p1Position;			
					getXCoordinate();		
					getYCoordinate();	
					while(!finishMove){
						currentX = redLabel.getX();
						currentY = redLabel.getY();
						try {
						    Thread.sleep(10);                 
						} catch(InterruptedException ex) {
						    Thread.currentThread().interrupt();
						}					
						move();						
						redLabel.setBounds(currentX, currentY, 40, 40);
						if (currentX == pieceX && currentY == pieceY){
							finishMove = true;
						}
					}
					finishMove = false;
				}	
			}					
		}
		if (currentPiece.equals("Blue")){
			if (specialPosition){
				p2Position = finalPosition;
				currentPosition = finalPosition;
				getXCoordinate();		
				getYCoordinate();
				blueLabel.setBounds(pieceX, (pieceY + 10), 40, 40);
			} else {
				for (int i = p2Position; i < finalPosition; i++){
					p2Position++;
					currentPosition = p2Position;			
					getXCoordinate();		
					getYCoordinate();	
					pieceY += 10;
					while(!finishMove){
						currentX = blueLabel.getX();
						currentY = blueLabel.getY();
						try {
						    Thread.sleep(10);                 //1000 milliseconds is one second.
						} catch(InterruptedException ex) {
						    Thread.currentThread().interrupt();
						}					
						move();						
						blueLabel.setBounds(currentX, currentY, 40, 40);
						if (currentX == pieceX && currentY == pieceY){
							finishMove = true;
						}
					}
					finishMove = false;
				}		
			}
		}
		if (currentPiece.equals("Yellow")){
			if (specialPosition) {
				p3Position = finalPosition;
				currentPosition = finalPosition;
				getXCoordinate();		
				getYCoordinate();
				yellowLabel.setBounds(pieceX, (pieceY + 20), 40, 40);
			} else {
				for (int i = p3Position; i < finalPosition; i++){
					p3Position++;
					currentPosition = p3Position;			
					getXCoordinate();		
					getYCoordinate();	
					pieceY += 20;
					while(!finishMove){
						currentX = yellowLabel.getX();
						currentY = yellowLabel.getY();
						try {
						    Thread.sleep(10);                 //1000 milliseconds is one second.
						} catch(InterruptedException ex) {
						    Thread.currentThread().interrupt();
						}					
						move();						
						yellowLabel.setBounds(currentX, currentY, 40, 40);
						if (currentX == pieceX && currentY == pieceY){
							finishMove = true;
						}
					}
					finishMove = false;
				}	
			} 
		}
		if (currentPiece.equals("Black")) {
			if (specialPosition) {
				p4Position = finalPosition;
				currentPosition = finalPosition;
				getXCoordinate();		
				getYCoordinate();
				blackLabel.setBounds(pieceX, (pieceY + 30), 40, 40);
			} else {
				for (int i = p4Position; i < finalPosition; i++){
					p4Position++;
					currentPosition = p4Position;			
					getXCoordinate();		
					getYCoordinate();	
					pieceY += 30;
					while(!finishMove){
						currentX = blackLabel.getX();
						currentY = blackLabel.getY();
						try {
						    Thread.sleep(10);                 //1000 milliseconds is one second.
						} catch(InterruptedException ex) {
						    Thread.currentThread().interrupt();
						}					
						move();						
						blackLabel.setBounds(currentX, currentY, 40, 40);
						if (currentX == pieceX && currentY == pieceY){
							finishMove = true;
						}
					}
					finishMove = false;
				}		
			} 
		}
	}
	
	/**
	 * Method to move piece 
	 * @see displayMoveAnimation(String colour, int position, boolean specialPosition), called by
	 */		
	private void move(){
		if (currentY == pieceY){
			if (currentX < pieceX){
				currentX += 2;
			} 
			if (currentX > pieceX) {
				currentX -= 2;
			}
		} else {
			currentY -= 2;
		}		
	}
	
	/**
	 * Method to set x coordinate
	 * @see displayMoveAnimation(String colour, int position, boolean specialPosition), called by
	 */		
	private void getXCoordinate() {
		if((currentPosition % 20 == 0) || (currentPosition % 20 == 1)){
			pieceX = 150;
		} else if((currentPosition % 20 == 2) || (currentPosition % 20 == 19)){
			pieceX = 220;
		} else if((currentPosition % 20 == 3) || (currentPosition % 20 == 18)){
			pieceX = 290;
		} else if((currentPosition % 20 == 4) || (currentPosition % 20 == 17)){
			pieceX = 360;
		} else if((currentPosition % 20 == 5) || (currentPosition % 20 == 16)){
			pieceX = 430;
		} else if((currentPosition % 20 == 6) || (currentPosition % 20 == 15)){
			pieceX = 500;
		} else if((currentPosition % 20 == 7) || (currentPosition % 20 == 14)){
			pieceX = 570;
		} else if((currentPosition % 20 == 8) || (currentPosition % 20 == 13)){
			pieceX = 640;
		} else if((currentPosition % 20 == 9) || (currentPosition % 20 == 12)){
			pieceX = 710;
		} else {
			pieceX = 780;			
		}		
	}
	
	/**
	 * Method to set y coordinate
	 * @see displayMoveAnimation(String colour, int position, boolean specialPosition), called by
	 */		
	private void getYCoordinate() {
		if(currentPosition >= 91){
			pieceY = 136;
		} else if(currentPosition >= 81){
			pieceY = 206;
		} else if(currentPosition >= 71){
			pieceY = 276;
		} else if(currentPosition >= 61){
			pieceY = 346;
		} else if(currentPosition >= 51){
			pieceY = 416;
		} else if(currentPosition >= 41){
			pieceY = 486;
		} else if(currentPosition >= 31){
			pieceY = 556;
		} else if(currentPosition >= 21){
			pieceY = 626;
		} else if(currentPosition >= 11){
			pieceY = 696;
		} else {
			pieceY = 766;			
		}		
	}
	
	/**
	 * Method to return rollButton
	 * @see SnakesAndLadders, called by
	 * @param JButton rollButton
	 */			
	public JButton getRollButton(){
		return rollButton;		
	}

	/**
	 * Method to stop the timer
	 * @see SnakesAndLadders, called by
	 */	
	public void stopTime() {
		timer.stop();			
	}
}
