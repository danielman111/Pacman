package GameComponants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.JFrame;

/*Name: GameFrame
propose: This class is the frame that shows the game and the stats
author: Gal Luvton and Daniel Sinaniev
Date Created: 27/6/2013
Last modification: 08/7/2013
*/

public class GameFrame extends JFrame{
	
	/*Fields*/
	//the panel of the buttom of the game window
	private StatsPanel buttomPanel;
	//the game itself
	private MainBoard game;
	//the highscores table
	private HighScores highscoresTable;
	//HIGHSCORES__FILE- the location of the game's highscore save file
	public static final String HIGHSCORES_FILE= "highscores.dat";
	
	
	/*Behavior*/
	/*Constructors*/
	//starts a new game
	public GameFrame(){
		super("Pacman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.game= new MainBoard(this);
		addKeyListener(this.game);
		try{	//tries loading the highscores
			File file = new File(GameFrame.HIGHSCORES_FILE);
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			this.highscoresTable= (HighScores)objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
		}	//if the highscores cannot be loaded, initializes them
		catch (Exception e){
			this.highscoresTable= new HighScores();
		}
		this.getContentPane().add(this.game);
		this.buttomPanel= new StatsPanel();
		this.getContentPane().add(this.buttomPanel, BorderLayout.SOUTH);
		Dimension size = getToolkit().getScreenSize();	//sets the size of the menu and sets it to open mid-screen
		setLocation(size.width/2-getWidth()/2 - 350, size.height/2 - getHeight()/2 - 400);
		setSize(MainBoard.BACKGROUND.getIconWidth(), 800);
		getContentPane().setBackground(Color.BLACK);
		setResizable(false);
		setVisible(true);
	}
	
	
	//deducts one life from the user. ends the game if no more lives are left
	public void lostLife(){
		if (this.buttomPanel.lostLife()){
			GameOver endScreen= new GameOver();
			dispose();
		}
		else
			this.game.resetLocations();
	}
	
	
	//the user ate one dot. ends the game if there are no more dots left
	public void ateDot(int foodLeft){
		InsertHighScore inputName;
		if (foodLeft == 0){
			int userscore= this.buttomPanel.getScore();
			inputName= new InsertHighScore(userscore, this.highscoresTable);
			dispose();
		}
		else
			this.buttomPanel.addPoints(100);
	}
	
	
	//the user ate a ghost
	public void ateGhost(){
		this.buttomPanel.addPoints(500);
	}
	
	
	//the Main method, starts the whole program
	public static void main(String[] args){
		GameFrame play= new GameFrame();
	}

	
}//GameFrame
