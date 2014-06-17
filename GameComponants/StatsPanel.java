package GameComponants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*Name: StatsPanel
propose: This class is the panel on the bottom of the game frame
author: Gal Luvton and Daniel Sinaniev
Date Created: 27/6/2013
Last modification: 08/7/2013
*/

public class StatsPanel extends JPanel{

	/*Fields*/
	//keeps the score
	private ScoreLabel scores;
	//tells how many lives are left, visually
	private JLabel life;
	//tells how many lives are left, numerically
	private int lifeInd;
	//the cherry icon
	private final ImageIcon CHERRY=  new ImageIcon(StatsPanel.class.getResource("/Resources/cherry.jpg"));
	//the lives icon
	private final ImageIcon[] LIFES= {new ImageIcon(StatsPanel.class.getResource("/Resources/life1.jpeg")), 
									  new ImageIcon(StatsPanel.class.getResource("/Resources/life2.jpeg")),  
									  new ImageIcon(StatsPanel.class.getResource("/Resources/life3.jpeg")), };
	
	
	/*Behavior*/
	/*Constructors*/
	//creates a new StatsPanel
	public StatsPanel(){
		super(new BorderLayout());
		setBackground(Color.BLACK);
		JPanel rightSide= new JPanel(new GridBagLayout());
		this.scores= new ScoreLabel();
		this.lifeInd= 2;
		this.life= new JLabel();
		this.life.setIcon(LIFES[this.lifeInd]);
		JLabel cImage= new JLabel();
		cImage.setIcon(CHERRY);
		add(this.scores, BorderLayout.WEST);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		rightSide.add(this.life, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		rightSide.add(cImage, c);
		add(rightSide, BorderLayout.EAST);
	}
	
	
	//adds 'num' points to the current score
	public void addPoints(int num){
		this.scores.incScore(num);
	}
	
	
	//removes one life from the life index
	public boolean lostLife(){
		if (this.lifeInd > 0){
			this.lifeInd--;
			this.life.setIcon(LIFES[this.lifeInd]);
			return false;
		}
		return true;
	}
	
	
	//returns the user's score
	public int getScore(){
		return this.scores.getScore();
	}
	
	
}//StatsPanel
