package A3;

/**
 * @file Board.java
 * @author Avishek Siris
 * @date 03 Dec 2014
 * @see SALGUI.java; called by to display board
 * 
 * @Brief Class to display board, snakes and ladders
 * 
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {

	private int currentPosition;
	private int pieceX;
	private int pieceY;
	private ArrayList<SnakePoints> sPointsList;
	private ArrayList<LadderPoints> lPointsList;
	private BufferedImage image;

	/**
	 * Constructor of class 
	 * @param ArrayList<SnakePoints> snakesList, points of snakes
	 * @param ArrayList<LadderPoints> laddersList, points of ladders
	 */	
	public Board(ArrayList<SnakePoints> snakesList, ArrayList<LadderPoints> laddersList){
		sPointsList = snakesList;
		lPointsList = laddersList;

		//Gets image of board
		URL resource = getClass().getResource("image/SAL Board.jpg");
		try {
			image = ImageIO.read(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to paint into a window
	 * @param Graphics g, graphics component
	 */	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);  

		//Draw image
		g.drawImage(image, 3, 4, this);	

		//Sets colour
		g.setColor(Color.RED);

		//Draws lines for snakes
		for (SnakePoints snakes: sPointsList){			
			int head = snakes.getSnakeHead();
			int tail = snakes.getSnakeTail();

			currentPosition = head;
			getXCoordinate();
			int x1 = pieceX;
			getYCoordinate();
			int y1 = pieceY;

			currentPosition = tail;
			getXCoordinate();
			int x2 = pieceX;
			getYCoordinate();
			int y2 = pieceY;

			Graphics2D g2 = (Graphics2D) g;

			g2.setStroke(new BasicStroke(3));
			g2.drawLine((x1 - 120), (y1 - 100), (x2 - 110), (y2 - 100));
		}       

		//Sets colour
		g.setColor(Color.decode("#33CC33"));
		
		//Draws lines for ladders
		for (LadderPoints ladders: lPointsList){			
			int head = ladders.getLadderTop();
			int tail = ladders.getLadderBottom();

			currentPosition = head;
			getXCoordinate();
			int x1 = pieceX;
			getYCoordinate();
			int y1 = pieceY;

			currentPosition = tail;
			getXCoordinate();
			int x2 = pieceX;
			getYCoordinate();
			int y2 = pieceY;
			
			Graphics2D g3 = (Graphics2D) g;

			g3.setStroke(new BasicStroke(3));
			g3.drawLine((x1 - 115), (y1 - 100), (x2 - 105), (y2 - 100));			
			g3.drawLine((x1 - 125), (y1 - 100), (x2 - 115), (y2 - 100));
		}         
	}
	
	/**
	 * Method to set x coordinates 
	 * @see paintComponent(Graphics g); called by to get x coordinates
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
	 * Method to set y coordinates 
	 * @see paintComponent(Graphics g); called by to get y coordinates
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
}
