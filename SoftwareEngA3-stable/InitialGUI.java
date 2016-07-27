/**
* @file InitialGUI.java
* @author Patrick Socha
* @date 07 Dec 2014
*
* @Brief InitialGUI launches the game selected and passes user paramaters on to the appropriate classes.
*/

package A3;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import java.util.ArrayList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class InitialGUI {
		JFrame frame = new JFrame();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();


		private final String ttt = "tictactoe";
		private final String sal = "snakesandladders";
		private final String[] COLORSWORDS = {"Blue", "Red", "Yellow", "Black"}; // Blue, Red, Yellow, Black
		private final String[] COLORSHEX = {"#0000ff", "#ff0000", "#ffff00", "#000000"}; // Blue, Red, Yellow, Black
		private final int SAL_STARTPOSITION = 0;
		private ArrayList<PlayerSAL> salPlayerList = new ArrayList<PlayerSAL>();
		private ArrayList<PlayerTTT> tttPlayerList = new ArrayList<PlayerTTT>();
		private ArrayList<String> colorValue = new ArrayList<String>();
		private ArrayList<JTextField> nameValue = new ArrayList<JTextField>();
		private ArrayList<String> symbolValue = new ArrayList<String>();
		private final String TTT_PLAYER_TYPE = "human";
		private JTextField snakesField;
		private JTextField laddersField;

		public static void main(String[] args){

			InitialGUI begin = new InitialGUI();
			begin.start();

		}

		public void start(){

				JButton ticTacToe;
				JLabel gameOrLabel;
				JButton snakesAndLadders;
				JLabel gameSelectLabel;

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(400, 200);
				frame.setVisible(true);

				frame.getContentPane().add(panel1);
				panel1.setLayout(null);

				gameSelectLabel = new JLabel("Which game would you like to play?");
				gameSelectLabel.setBounds(70,10,300,35);
				panel1.add(gameSelectLabel);

				snakesAndLadders = new JButton("Snakes and Ladders");
				snakesAndLadders.setBounds(90,50,210,35);
				panel1.add(snakesAndLadders);

				// Player Name
				gameOrLabel = new JLabel("- or -");
				gameOrLabel.setBounds(180, 85,300,35);
				panel1.add(gameOrLabel);

				ticTacToe = new JButton("Dan's Crazy Tic Tac Toe");
				ticTacToe.setBounds(90,120,210,35);
				panel1.add(ticTacToe);


		snakesAndLadders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				snakesAndLaddersForm(0);

			}
		});


		ticTacToe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ticTacToeForm();

			}
		});


		}

		public void snakesAndLaddersForm(int playerNumber){
				frame.setSize(400, 400);
				panel2.setLayout(null);

				JLabel label;
				int playerInsertId;
				JButton print;
				JTextField nameField;
				int abs_height = 20;
				int abs_addPlayerBtnHeight = 300;
				int abs_addStartBtnHeight = 150;
				JButton addPlayerButton;
				JButton startButton;
				playerInsertId = playerNumber;

				label = new JLabel("Snakes and Ladders");
				label.setBounds(20,abs_height,210,35);
				panel2.add(label);

			for (int i = 0; i < 4; i++){
				abs_height = abs_height + 40;


					nameField = new JTextField();
					nameField.setBounds(75, abs_height, 100, 35);
					panel2.add(nameField);
					nameValue.add(nameField);

					displaySALelements(abs_height);

				JLabel colorLabel = new JLabel();
				colorLabel.setBounds(280,abs_height,50,35);
				colorLabel.setOpaque(true);
				colorLabel.setBackground(Color.decode(COLORSHEX[i]));
				panel2.add(colorLabel);
				colorValue.add(COLORSHEX[i]);
			}

			askSnakesLadderNumber(abs_height);

			addPlayerButton = new JButton("Start the game »");
			addPlayerButton.setBounds(90,abs_addPlayerBtnHeight,210,35);
			panel2.add(addPlayerButton);

			addPlayerButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					for (int i = 0; i < 4; i++){

						String name = nameValue.get(i).getText();
						String color = colorValue.get(i);
						if (name.isEmpty()){
							System.out.println("Empty user. Skipping!");
						} else {
							addPlayerSAL(name, color);
						}

					}

						// new SnakesAndLadders(salPlayerList, snakesField, laddersField);

				}
			});

			frame.getContentPane().remove(panel1);
			frame.getContentPane().add(panel2);
			frame.getContentPane().revalidate();
			frame.getContentPane().repaint();
		}









		public void ticTacToeForm(){
				frame.setSize(400, 200);
				panel3.setLayout(null);
				int abs_height = 0;

				JLabel m_title = new JLabel("Dan's Crazy Tic Tac Toe");
				m_title.setBounds(20,abs_height,210,35);
				panel3.add(m_title);

				JLabel label;
				for (int i = 0; i < 2; i++){
					abs_height = abs_height + 40;


					JTextField nameField = new JTextField();
					nameField.setBounds(75, abs_height, 100, 35);
					panel3.add(nameField);
					nameValue.add(nameField);

					displayTTTelements(abs_height);

					JLabel tttSymbol;
					if (i == 0){
						tttSymbol = new JLabel("x");
						symbolValue.add("x");
					} else {
						tttSymbol = new JLabel("o");
						symbolValue.add("o");
					}
					tttSymbol.setBounds(290,abs_height,210,35);
					panel3.add(tttSymbol);


				}


				JButton start = new JButton("Start the game »");
				start.setBounds(90,120,210,35);
				panel3.add(start);

				start.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						for (int i = 0; i < 2; i++){

							String name = nameValue.get(i).getText();
							String userSymbol = symbolValue.get(i);
							if (name.isEmpty()){
								addPlayerTTT("Player"+userSymbol, userSymbol);
							} else {
								addPlayerTTT(name, userSymbol);
							}

						}

					new TicTacToeGUI(tttPlayerList);
					frame.setVisible(false);

					}
				});

				frame.getContentPane().remove(panel1);
				frame.getContentPane().add(panel3);
				frame.getContentPane().revalidate();
				frame.getContentPane().repaint();
		}











		private void displaySALelements(int abs_height){

			JLabel label;
			JCheckBox ai;

			label = new JLabel("Name");
			label.setBounds(20,abs_height,210,35);
			panel2.add(label);

			label = new JLabel("AI:");
			label.setBounds(185, abs_height,210,35);
			panel2.add(label);

			ai = new JCheckBox();
			ai.setBounds(200, abs_height, 20, 35);
			panel2.add(ai);

			label = new JLabel("Colour:");
			label.setBounds(230, abs_height,210,35);
			panel2.add(label);

		}

		private void askSnakesLadderNumber(int abs_height){
			// abs_height for number of Snakes and Ladders

			JLabel noSALLabel = new JLabel("Enter the .no of Snakes and Ladders to play with");
			noSALLabel.setBounds(25,abs_height + 35,400,35);
			panel2.add(noSALLabel);

			abs_height = abs_height + 65;

			JLabel snakeLabel = new JLabel("Snakes: ");
			snakeLabel.setBounds(25,abs_height,400,35);
			panel2.add(snakeLabel);

			snakesField = new JTextField();
			snakesField.setBounds(80, abs_height, 100, 35);
			panel2.add(snakesField);
			nameValue.add(snakesField);

			JLabel laddersLabel = new JLabel("Ladders: ");
			laddersLabel.setBounds(185,abs_height,400,35);
			panel2.add(laddersLabel);

			laddersField = new JTextField();
			laddersField.setBounds(250, abs_height, 100, 35);
			panel2.add(laddersField);
			nameValue.add(laddersField);
		}

		private void displayTTTelements(int abs_height){

			JLabel label;
			JCheckBox ai;

			label = new JLabel("Name");
			label.setBounds(20,abs_height,210,35);
			panel3.add(label);

			label = new JLabel("AI:");
			label.setBounds(185, abs_height,210,35);
			panel3.add(label);

			ai = new JCheckBox();
			ai.setBounds(200, abs_height, 20, 35);
			panel3.add(ai);

			label = new JLabel("Symbol:");
			label.setBounds(230, abs_height,210,35);
			panel3.add(label);

		}

	private void addPlayerSAL(String name, String colour){
		System.out.println("Player added: " + name + " with colour " + colour);
		PlayerSAL player = new PlayerSAL(name, colour, SAL_STARTPOSITION);
		salPlayerList.add(player);
	}

	private void addPlayerTTT(String name, String token){
		// System.out.println("Player added: " + textField.getText() + " with colour " + colour);
		PlayerTTT player = new PlayerTTT(name, token, TTT_PLAYER_TYPE);
		tttPlayerList.add(player);
	}

	private void clear(){

		salPlayerList.clear();
		tttPlayerList.clear();
		colorValue.clear();
		nameValue.clear();
		symbolValue.clear();

	}

}
