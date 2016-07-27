/**
 * @file ResultsGUI.java
 * @author Oscar Crowley
 * @date 05 Dec 2014
 * @see EndGame called once the button to close is pressed
 * @see PlayerTTT accesses information to get the winning player name and information
 * @see PlayerSAL accessed information to get the winning player name and information
 *
 * Opens a GUI once the win conditions have been met that displays information about the game and
 * prompts the player to play again or terminate the game
 * 
 */


package A3;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class ResultsGUI {

	static EndGame m_endGame;

	private static final int PANEL_HEIGHT = 200;
	private static final int PANEL_LEN = 400;
	private static final int LEFT_ALIGN = 20;
	private static final int TITLE_SIZE = 20;
	private static final int TITLE_LEN = 60;
	private static final int TITLE_POS = PANEL_LEN/2 - TITLE_LEN/2;
	private static final int NORM_SIZE = 15;
	private static final int NORM_LEN = 200;
	private static final int SPACE = 20;
	private static final String TITLE = "RESULTS";

	private static String m_playerName;
	private static String m_finishTime;


	/*public void main(String[] args){
			int[][] testA = new int[8][8];
			PlayerTTT test = new PlayerTTT("Oscar", "T", "");
			test.setPlayerPositionTTT(0,0,1);
			test.setPlayerPositionTTT(0,1,1);
			test.setPlayerPositionTTT(0,2,1);
			test.setPlayerPositionTTT(0,3,1);
			test.setPlayerPositionTTT(0,4,1);
			testA[0][0] = 1;
			testA[0][1] = 1;
			testA[0][2] = 1;
			testA[0][3] = 1;
			testA[0][4] = 1;
			m_displayResults(test);
		}
	 */
	// public void ResultsGUI (PlayerTTT winner, String time){
	// 	m_displayResults(winner, time);
	// }

	public static void m_displayResults(PlayerTTT winner, String time){

		m_playerName = winner.getName();
		m_finishTime = time;

		m_endGame = new EndGame();

		final JFrame results = new JFrame(TITLE);
		results.setSize(PANEL_LEN,PANEL_HEIGHT);
		results.setLayout(null);
		results.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		results.setVisible(true);

		JLabel lblResTitle = new JLabel("Results", JLabel.LEFT);
		results.setLayout(null);
		lblResTitle.setBounds(TITLE_POS, SPACE, TITLE_LEN, TITLE_SIZE);
		results.add(lblResTitle);

		//JLabel lblWinPlayName = new JLabel("Player:", JLabel.LEFT);
		JLabel lblWinPlayName = new JLabel("Winner: " + m_playerName, JLabel.LEFT);
		int space = SPACE + TITLE_SIZE + SPACE;
		results.setLayout(null);
		lblWinPlayName.setBounds(LEFT_ALIGN, space, NORM_LEN, NORM_SIZE);
		results.add(lblWinPlayName);

		//JLabel lblWinTime = new JLabel("Finish Time:", JLabel.LEFT);
		JLabel lblWinTime = new JLabel(m_finishTime, JLabel.LEFT);
		space = space + NORM_SIZE + SPACE;
		results.setLayout(null);
		lblWinTime.setBounds(LEFT_ALIGN, space, NORM_LEN, NORM_SIZE);
		results.add(lblWinTime);

		/*GameBoard finishedGame = new TTTBoard();
       space = space + NORM_SIZE + SPACE;
       finishedGame.setLayout(null);
       finishedGame.setBounds(0, space, 528, 333);
       results.add(finishedGame);*/


		JButton addPlayerButton = new JButton("Ok!");
		int abs_addPlayerBtnHeight = 125;
		addPlayerButton.setBounds(90,abs_addPlayerBtnHeight,210,35);
		results.add(addPlayerButton);

		addPlayerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				results.setVisible(false);
				EndGame.showEndGame();
			}
		});
	}


	public static void m_displayResults(String winner, String time) {
		m_playerName = winner;
		m_finishTime = time;

		m_endGame = new EndGame();

		final JFrame results = new JFrame(TITLE);
		results.setSize(PANEL_LEN,PANEL_HEIGHT);
		results.setLayout(null);
		results.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		results.setVisible(true);

		JLabel lblResTitle = new JLabel("Results", JLabel.LEFT);
		results.setLayout(null);
		lblResTitle.setBounds(TITLE_POS, SPACE, TITLE_LEN, TITLE_SIZE);
		results.add(lblResTitle);

		//JLabel lblWinPlayName = new JLabel("Player:", JLabel.LEFT);
		JLabel lblWinPlayName = new JLabel("Winner: " + m_playerName, JLabel.LEFT);
		int space = SPACE + TITLE_SIZE + SPACE;
		results.setLayout(null);
		lblWinPlayName.setBounds(LEFT_ALIGN, space, NORM_LEN, NORM_SIZE);
		results.add(lblWinPlayName);

		//JLabel lblWinTime = new JLabel("Finish Time:", JLabel.LEFT);
		JLabel lblWinTime = new JLabel(m_finishTime, JLabel.LEFT);
		space = space + NORM_SIZE + SPACE;
		results.setLayout(null);
		lblWinTime.setBounds(LEFT_ALIGN, space, NORM_LEN, NORM_SIZE);
		results.add(lblWinTime);

		/*GameBoard finishedGame = new SALBoard();
       space = space + NORM_SIZE + SPACE;
       finishedGame.setLayout(null);
       finishedGame.setBounds(0, space, 528, 333);
       results.add(finishedGame);*/


		JButton addPlayerButton = new JButton("Ok!");
		int abs_addPlayerBtnHeight = 125;
		addPlayerButton.setBounds(90,abs_addPlayerBtnHeight,210,35);
		results.add(addPlayerButton);

		addPlayerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				results.setVisible(false);
				EndGame.showEndGame();
			}
		});
	}
}
