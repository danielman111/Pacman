package GameComponants;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*Name: InsertHighScore
propose: This class creates a popup asking the user to input a name for the highscores table
author: Gal Luvton and Daniel Sinaniev
Date Created: 27/6/2013
Last modification: 08/7/2013
*/

public class InsertHighScore extends JFrame implements ActionListener {
	
	/*Fields*/
	//ok- a button that will close the popup
	private final JButton OK = new JButton("ok");
	//nameLabel- a label telling the use to insert his name 
	private final JLabel nameLabel = new JLabel("Insert your name, with the maximum of 20 letters");
	//newHigh- a label telling the user he has a new high score
	private final JLabel newHigh = new JLabel("Congratulations! You reached a new high score!");
	//text- a text field where the user will insert his name
	private JTextField text;
	//name- the name the user entered
	private String name;
	//theHighScores- the highscores table
	private HighScores theHighScores;
	// theUserScore- the user's new score
	int theUserScore;

	
	/*Behavior*/
	/*Constructors*/
	//this constructor creates the popup
	public InsertHighScore (int theUserScore, HighScores scoreTable){
		super("New High Score");
		this.theUserScore= theUserScore;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());

		this.theHighScores= scoreTable;
		JLabel userScore= new JLabel("Your new high score is: " + theUserScore);
		JPanel pane =new JPanel(new GridLayout(0, 1));
		this.text= new JTextField();
		OK.addActionListener(this);	//sets this as the "ok" button's action listener
		this.text.setColumns(10);

		GridBagConstraints cont = new GridBagConstraints();
		cont.insets = new Insets(10,5,10,5);	//sets the location of all the components
		GridBagConstraints tLabelConst = (GridBagConstraints)cont.clone();
		tLabelConst.fill = GridBagConstraints.NONE;
		tLabelConst.weightx = 0.0;

		GridBagConstraints grid = (GridBagConstraints)tLabelConst.clone();
		grid.gridx = 0; grid.gridy = 0;
		add(this.newHigh, grid);

		GridBagConstraints grid0 = (GridBagConstraints)tLabelConst.clone();
		grid0.gridx = 0; grid0.gridy = 1;
		add(userScore, grid0);


		GridBagConstraints grid1 = (GridBagConstraints)tLabelConst.clone();
		grid1.gridx = 0; grid1.gridy = 2;
		add(this.nameLabel, grid1);

		GridBagConstraints grid2 = (GridBagConstraints)tLabelConst.clone();
		grid2.gridx = 0; grid2.gridy = 3;
		add(this.text, grid2);

		GridBagConstraints grid3 = (GridBagConstraints)tLabelConst.clone();
		grid3.gridx = 0; grid3.gridy = 4;
		add(this.OK, grid3);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension size = this.getToolkit().getScreenSize();
		this.setLocation(size.width/2-this.getWidth()/2 - 150, size.height/2 - this.getHeight()/2 - 150);
		this.setSize(400, 270);
		this.setResizable(false);
		this.setVisible(true);
	}//InsertHighScore(int, HighScores)


	//implements the ActionListener interface
	//adds the user's score and name to the highscores table
	public void actionPerformed(ActionEvent e){
		this.name= "";
		boolean isGoodName= true;
		if (e.getSource() == this.OK){
			this.name = this.text.getText();
			isGoodName= (this.name.length() <= 20);
			if (!isGoodName)
				JOptionPane.showMessageDialog(this, "Your name is too long");
			else {
				for(int i=0; ((i < this.name.length()) && (isGoodName)); i++){	//checks the user name is in english 
					char check= this.name.charAt(i);
					if(!(((check >= 'a') && (check <= 'z')) || ((check >= 'A') && (check <= 'Z')) || ((check >= '0') && (check <= '9'))))
						isGoodName= false;
				}
				if(isGoodName){	//sends the name and score to the highscores table and closes this popup
					this.theHighScores.changeHighScore(this.theUserScore, this.name);
					this.theHighScores.showScores(true);
					dispose();
				}
				else
					JOptionPane.showMessageDialog(this, "Insert your name in English");
			}
		}
	}//actionPerformed(ActionEvent)

}//class InsertHighScore
