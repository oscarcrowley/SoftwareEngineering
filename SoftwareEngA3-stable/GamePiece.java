/**
* @file GamePiece.java
* @author 
* @date 28 Nov 2014
* 
*
* Creates the game pieces for the Snakes and Ladders game
*/

package A3;
import A3.*;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class GamePiece extends JPanel {
	private Graphics g2;
	private Color colour;

	public GamePiece(int r, int g, int b, int o){
		colour = new Color(r,g,b,o);
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);    
 
        g2 = (Graphics) g.create();
        
 		g2.setColor(colour);
 		
 			
		g2.fillOval(0, 0, 25, 25); 	
	}
	
}


