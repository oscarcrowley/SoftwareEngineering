/** 
* @file EndGame.java
* @author Oscar Crowley
* @date 03 Dec 2014
* @see InitialGUI.java calls if selected
*
* Gives the option to restart or terminate program
*/

package A3;


import javax.swing.*;

public class EndGame extends JFrame {
	//public static void main(String[] args) {

    public static void showEndGame() {

	    String[] options = new String[] {"Yes", "No"};
	    int response = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Play again?",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	        null, options, options[0]);

	    	//Where response == 0 for Yes, 1 for No

	    if(response == 0){

            // JFrame frame = new JFrame("Game Setup");
            // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // frame.getContentPane().add(new InitialGUI());
            // frame.pack();
            // frame.setVisible(true);

			InitialGUI initialGui = new InitialGUI();
			initialGui.start();

        }

	    else {

            System.exit(0);

            //Terminates program
         }

	}

}
