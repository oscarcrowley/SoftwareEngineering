package A3;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

/**
* @file TicTacToeGUI.java
* @Author Patrick Socha
* @Date 07 Dec 2014
* @see Clock.java; call from clock to show time
*
* @Create the visual gui for Tic Tac Toe Game.
*/

public class TicTacToeGUI {
		 JFrame frame = new JFrame();
		 JPanel panel1 = new JPanel();
		 JPanel panel2 = new JPanel();
		 JPanel panel3 = new JPanel();
		// symbolsArray = new JButton[9][9];

		private  JButton selectSlot;
		private  int whichPlayer = 0;
		private  ArrayList<PlayerTTT> salPlayerList = new ArrayList<PlayerTTT>();
		private  String[][] symbolsArray = new String[9][9];
		private  JButton[][] buttonsArray = new JButton[9][9];
		private  Clock clock;
		private  JLabel clockLabel;
		private  JLabel whichPlayerLabel;
		private  ArrayList<PlayerTTT> playerList;
		private  Win win = new Win();
		private Timer timer;

		public TicTacToeGUI(ArrayList<PlayerTTT> players){

			playerList = players;

			clock = new Clock();
			clock.setGameStartTime();
			ticTacToeGrid();

			// close();

		}

		// private void close(){

			// TicTacToeGUI.add

		// }

		public void ticTacToeGrid(){


			String symbol;

			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800, 900);
			frame.setVisible(true);

			displayClock();
			dashboard();


			for (int i = 1; i < 9; i++){

				for (int j = 1; j < 9; j++){

					final int x = i - 1;
					final int y = j - 1;

					symbol = symbolsArray[x][y];
					buttonsArray[x][y] = new JButton(symbol);
					buttonsArray[x][y].setBounds(75 * i,75 * j,75,75);
					panel1.add(buttonsArray[x][y]);


					buttonsArray[x][y].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {

							int playerID;
							String textSymbol;
							boolean winCondition;
							System.out.println("Button " + x + " " + y);


							if (buttonsArray[x][y].getText() == ""){

								if (whichPlayer%2 == 0){
									playerID = 0;
									textSymbol = "x";
									whichPlayerLabel.setText("Player turn: " + playerList.get(playerID+1).getName());
								} else {
									playerID = 1;
									textSymbol = "o";
									whichPlayerLabel.setText("Player turn: " + playerList.get(playerID-1).getName());
								}

								buttonsArray[x][y].setText(textSymbol);
								symbolsArray[x][y] = textSymbol;
								playerList.get(playerID).setPlayerPositionTTT(x, y, 1);

								// System.out.println(x + " " + y);

								winCondition = win.m_checkTTTWin(playerList.get(playerID), clockLabel.getText());

								if (winCondition){
									buttonsArray = showWinningLine(buttonsArray, win.getWinningPosition());
									timer.stop();
								}

								whichPlayer++;
							}


						}
					});

				}

			}

				// frame.getContentPane().remove(panel1);
				frame.getContentPane().add(panel1);
				frame.getContentPane().revalidate();
				frame.getContentPane().repaint();

				frame.getContentPane().add(panel1);
				panel1.setLayout(null);


		}

		private JButton[][] showWinningLine(JButton[][] buttonsArray, int[][] winningArray){

			// Clear board
			for (int i = 0; i < 8; i++){

				for (int j = 0; j < 8; j++){

					// if (isLosingPosition(winningArray) == false){

					// System.out.println(i + " " + j);
					buttonsArray[i][j].setText("");

					// }

				}
			}

			// Show board
			for (int i = 0; i < 8; i++){

				for (int j = 0; j < 8; j++){

					// System.out.println(i + " " + j);
					if (winningArray[i][j] == 1){
						buttonsArray[i][j].setText("Win!");
					}

				}
			}

			return buttonsArray;

		}

		private void dashboard(){

			clockLabel = new JLabel("Game run time: 00:00:00");
			clockLabel.setBounds(100,20,210,35);
			panel1.add(clockLabel);

			whichPlayerLabel = new JLabel("Player turn: " + playerList.get(0).getName());
			whichPlayerLabel.setBounds(100,35,210,35);
			panel1.add(whichPlayerLabel);

		}

		private void displayClock(){

			ActionListener taskPerformer = new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					clockLabel.setText("Game run time: " + clock.getGameTime());
				}
			};
			timer = new Timer(1000 ,taskPerformer);
			timer.setRepeats(true);
			timer.start();

		}


		// private boolean isLosingPosition(int[][] winningPosition){

		// 	boolean lose = true;

		// 	for (int i = 0; i < 8; i++){

		// 		for (int j = 0; j < 8; j++){

		// 			if(winningPosition[i][j] == 1){

		// 				System.out.println(i + " " + j);

		// 				lose = false;

		// 			}

		// 		}
		// 	}

		// 	return lose;

		// }

}
