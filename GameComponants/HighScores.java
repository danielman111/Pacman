package GameComponants;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*Name: HighScores
propose: This class represents the highscores table
author: Gal Luvton and Daniel Sinaniev
Date Created: 27/6/2013
Last modification: 08/7/2013
*/

public class HighScores extends JFrame implements ActionListener, Serializable{

	/*Fields*/
	//serialVersionUID- the object's ID, for saving purposes
	private static final long serialVersionUID = 6704564669825235310L;
	//firstHighScore- the first highscore on the table
	private JLabel firstHighScore;
	//secondHighScore- the second highscore on the table
	private JLabel secondHighScore;
	//thirdHighScore- the third highscore on the table
	private JLabel thirdHighScore;
	//forthHighScore- the forth highscore on the table
	private JLabel forthHighScore;
	//fifthHighScore- the fifth highscore on the table
	private JLabel fifthHighScore;
	//first- the first score
	private int first;
	//second- the second score
	private int second;
	//third- the third score
	private int third;
	//forth- the forth score
	private int forth;
	//fifth- the fifth score
	private int fifth;
	//DEFAULT- the default value for a new highscores table
	private final int DEFAULT= 0;
	//OK- the "ok" button
	private final JButton OK = new JButton("ok");
	//HIGHSCORE- the headline label for this table
	private final JLabel HIGHSCORE = new JLabel("HighScores");
	
	
	/*Behavior*/
	/*Constructors*/
	//this constructor creates a new highscores table
	public HighScores(){
		super("HighScores");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.first= this.DEFAULT;	//updates all values to their default values
		this.second= this.DEFAULT;
		this.third= this.DEFAULT;
		this.forth= this.DEFAULT;
		this.fifth= this.DEFAULT;
		
		this.firstHighScore= new JLabel("1. " + " daniel:  " + first);
		this.secondHighScore= new JLabel("2. " + " gal:  " + second);
		this.thirdHighScore= new JLabel("3. " + " leonid:  " + third);
		this.forthHighScore= new JLabel("4. " + " tal:  " + forth);
		this.fifthHighScore= new JLabel("5. " + " satan:  " + fifth);
		setLayout(new GridBagLayout());

		GridBagConstraints cont = new GridBagConstraints();
		cont.insets = new Insets(10,5,10,5);	//arranges the components on the frame

		GridBagConstraints tLabelConst = (GridBagConstraints)cont.clone();
		tLabelConst.anchor = GridBagConstraints.WEST;
		tLabelConst.fill = GridBagConstraints.NONE;
		tLabelConst.weightx = 0.0;

		GridBagConstraints t = (GridBagConstraints)cont.clone();
		tLabelConst.fill = GridBagConstraints.NONE;
		tLabelConst.weightx = 0.0;

		GridBagConstraints grid = (GridBagConstraints)t.clone();
		grid.gridx = 0; grid.gridy = 0;
		add(this.HIGHSCORE, grid);

		grid = (GridBagConstraints)tLabelConst.clone();
		grid.gridx = 0; grid.gridy = 1;
		add(this.firstHighScore, grid);

		grid = (GridBagConstraints)tLabelConst.clone();
		grid.gridx = 0; grid.gridy = 2;
		add(this.secondHighScore, grid);

		grid = (GridBagConstraints)tLabelConst.clone();
		grid.gridx = 0; grid.gridy = 3;
		add(this.thirdHighScore, grid);

		grid = (GridBagConstraints)tLabelConst.clone();
		grid.gridx = 0; grid.gridy = 4;
		add(this.forthHighScore, grid);

		grid = (GridBagConstraints)tLabelConst.clone();
		grid.gridx = 0; grid.gridy = 5;
		add(this.fifthHighScore, grid);

		grid = (GridBagConstraints)t.clone();
		grid.gridx = 0; grid.gridy = 6;
		add(this.OK, grid);
		OK.addActionListener(this);
		
		this.setSize(200, 300);	//sets the size of the frame and sets it to open mid-screen
		Dimension size = this.getToolkit().getScreenSize();
		this.setLocation(size.width/2-this.getWidth()/2 - 150, size.height/2 - this.getHeight()/2 - 150);
		this.setSize(300, 300);
		this.setResizable(false);
	}//HighScores

	
	//adds a new high score to the table and sets it in the right place
	public void changeHighScore(int newscore, String name){
		if (newscore > first){	//if the new score is the first one on the new table
			this.fifth= this.forth;
			this.forth= this.third;
			this.third= this.second;
			this.second= this.first;
			this.first= newscore;
			this.fifthHighScore.setText("5." + (this.forthHighScore.getText()).substring(2));
			this.forthHighScore.setText("4." + (this.thirdHighScore.getText()).substring(2));
			this.thirdHighScore.setText("3." + (this.secondHighScore.getText()).substring(2));
			this.secondHighScore.setText("2." + (this.firstHighScore.getText()).substring(2));
			this.firstHighScore.setText("1. " + name + ":  " + newscore);
		}	//if the new score is at least the second one on the new table
		else if (newscore > this.second){
			this.fifth= this.forth;
			this.forth= this.third;
			this.third= this.second;
			this.second= newscore;
			this.fifthHighScore.setText("5." + (this.forthHighScore.getText()).substring(2));
			this.forthHighScore.setText("4." + (this.thirdHighScore.getText()).substring(2));
			this.thirdHighScore.setText("3." + (this.secondHighScore.getText()).substring(2));
			this.secondHighScore.setText("2. " + name + ":  " + newscore);
		}	//if the new score is at least the third one on the new table
		else if (newscore > this.third){
			this.fifth= this.forth;
			this.forth= this.third;
			this.third= newscore;
			this.fifthHighScore.setText("5." + (this.forthHighScore.getText()).substring(2));
			this.forthHighScore.setText("4." + (this.thirdHighScore.getText()).substring(2));
			this.thirdHighScore.setText("3. " + name + ":  " + newscore);
		}	//if the new score is at least the forth one on the new table
		else if (newscore > this.forth){
			this.fifth= this.forth;
			this.forth= newscore;
			this.fifthHighScore.setText("5." + (this.forthHighScore.getText()).substring(2));
			this.forthHighScore.setText("4. " + name + ":  " + newscore);
		}	//if the new score is at least the fifth one on the new table
		else if (newscore > this.fifth){
			this.fifth= newscore;
			this.forthHighScore.setText("5. " + name + ":  " + newscore);
		}
		try {	//after updating the table, saves it to file
			FileOutputStream fileOutputStream = new FileOutputStream(GameFrame.HIGHSCORES_FILE);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(this);
			objectOutputStream.close();
			fileOutputStream.close();
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(this, "error while saving highscores", "", JOptionPane.ERROR_MESSAGE);
		}
	}//changeHighScore(int, String)

	
	//shows this frame
	public void showScores(boolean didGameEnd){
		this.setVisible(true);
	}//showScores(boolean)
	
	
	//implements the ActionListener interface
	//closes this frame
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.OK)){
			GameFrame play= new GameFrame();
			dispose();
		}
	}//actionPerformed(ActionEvent)
	
	
}//class HighScores