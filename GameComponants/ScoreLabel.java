package GameComponants;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*Name: ScoreLabel
propose: This class is the score on the bottom of the game frame
author: Gal Luvton and Daniel Sinaniev
Date Created: 27/6/2013
Last modification: 08/7/2013
*/

public class ScoreLabel extends JLabel{
	
	/*Fields*/
	//keeps the score
	private int score;
	
	
	/*Behavior*/
	/*Constructors*/
	//creates a new ScoreLabel
	public ScoreLabel(){
		super("SCORE: 0",  new ImageIcon(ScoreLabel.class.getResource("/Resources/back.jpeg")), JLabel.LEFT);
		setOpaque(false);
		this.score= 0;
		setForeground(Color.WHITE);
		setHorizontalTextPosition(JLabel.LEFT);
	}
	
	
	//increases score by 'score' points
	public void incScore(int score){
		this.score+= score;
		this.setText("SCORE: " + this.score);
	}
	
	
	//returns the user's score
	public int getScore(){
		return this.score;
	}
	
	
}//ScoreLabel
