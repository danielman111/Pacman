package GameComponants;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import Ghost.Ghost;
import Ghost.StrongGhost;
import Ghost.WeakGhost;
import Pacman.MightyPacman;
import Pacman.Pacman;
import Pacman.RegularPacman;
import Pacman.SuperPacman;

/*Name: MainBoard
propose: This class is the game board
author: Gal Luvton and Daniel Sinaniev
Date Created: 27/6/2013
Last modification: 08/7/2013
*/

public class MainBoard extends JPanel implements ActionListener, KeyListener{
	
	
	/*Fields*/
	// the game board (0-wall, 1-food, 2-mighty food, 3-super food, 4-clear, 5,6-tunnel)
						//   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27
	private int[][] board= {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},	//0
							{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},	//1
							{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},	//2
							{0, 3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0},	//3
							{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},	//4
							{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},	//5
							{0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0},	//6
							{0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0},	//7
							{0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0},	//8
							{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},	//9
							{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},	//10
							{0, 0, 0, 0, 0, 0, 1, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0},	//11
							{0, 0, 0, 0, 0, 0, 1, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0},	//12
							{0, 0, 0, 0, 0, 0, 1, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0},	//13
							{5, 4, 4, 4, 4, 4, 1, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 1, 4, 4, 4, 4, 4, 6},	//14
							{0, 0, 0, 0, 0, 0, 1, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0},	//15
							{0, 0, 0, 0, 0, 0, 1, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0},	//16
							{0, 0, 0, 0, 0, 0, 1, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0},	//17
							{0, 0, 0, 0, 0, 0, 1, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0},	//18
							{0, 0, 0, 0, 0, 0, 1, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0},	//19
							{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},	//20
							{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},	//21
							{0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 3, 0},	//22
							{0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0},	//23
							{0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},	//24
							{0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},	//25
							{0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0},	//26
							{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},	//27
							{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},	//28
							{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},	//29
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};  //30
	//the frame that holds this panel
	private GameFrame parent;
	//the player
	private Pacman player;
	//the ghosts
	private Ghost[] ghosts;
	//number of ghosts that are alive
	private int ghostsOnScreen;
	//the block in the middle of the board that houses the ghosts
	private GhostCenter ghostBlock;
	//the timer that releases ghosts
	private Timer ghostTimer;
	//the timer that moves all icons on the board
	private Timer moveTimer;
	//the timer that allows the death animation to run smoothly
	private Timer deathTimer;
	//the timer that tells how much time the player is empowered
	private Timer playerStateTimer;
	//is used to insure that the death animation to runs smoothly
	private int deathFrameCount;
	//tells if no moves were made yet
	private boolean firstMove;
	//is used for smooth player movement
	private int playerMoveCounter;
	//is used for smooth ghost movement
	private int ghostMoveCounter;
	//is used for the death animation
	private boolean isDead;
	//counts the amount of food left
	private int foodLeft;
	//the game maze
	public static final ImageIcon BACKGROUND= new ImageIcon(MainBoard.class.getResource("/Resources/background.jpg"));
	
	
	/*Behavior*/
	/*Constructors*/
	//starts a new game
	public MainBoard(GameFrame parent){
		this.parent= parent;
		this.foodLeft= 241;
		resetLocations();
	}
	
	
	//paints all the icons on the panel. uses the Double Buffering technique
	public void paint(Graphics g){		
		Image offIm = createImage(getSize().width, getSize().height);
		Graphics offGr = offIm.getGraphics();
		MainBoard.BACKGROUND.paintIcon(this, offGr, 0, 0);
		drawFood(offGr);
		drawAllMovment(offGr);
		g.drawImage(offIm, 0,0, this);
	}
	
	
	//draws the food on the panel
	private void drawFood(Graphics offGr){
		for (int i= 0; i < this.board.length; i++)
			for (int j= 0; j < this.board[i].length; j++){
				if (this.board[i][j] == 1){
					offGr.setColor(Color.YELLOW);
					offGr.fillRect(j*22 + 25, i*22 + 32, 5, 5);
				}
				else if (this.board[i][j] == 2){
							offGr.setColor(Color.RED);
							offGr.fillOval(j*22 + 20, i*22 + 27, 15, 15);
						}
				else if (this.board[i][j] == 3){
							offGr.setColor(Color.BLUE);
							offGr.fillOval(j*22 + 20, i*22 + 27, 15, 15);
						}
			}
	}
	
	
	//draws the player and ghosts movement on the panel
	private void drawAllMovment(Graphics offGr){
		int pX= this.player.getX()*22;	//calculates where the player is located in pixels
		int pY= this.player.getY()*22;
		if ((this.player.getFacing() == 0) && (this.player.checkCell(0)))
			pY= pY - (this.playerMoveCounter*2);
		else if ((this.player.getFacing() == 2) && (this.player.checkCell(2)))
			pY= pY + (this.playerMoveCounter*2);
		else if ((this.player.getFacing() == 1) && (this.player.checkCell(1)))
			pX= pX - (this.playerMoveCounter*2);
		else if ((this.player.getFacing() == 3) && (this.player.checkCell(3)))
			pX= pX + (this.playerMoveCounter*2);
		if (!this.isDead){
			(this.player.getIcon(false)).paintIcon(this, offGr, pY + 14, pX + 21);
			for (int i=0; i < 4; i++){
				int gX= this.ghosts[i].getX()*22;
				int gY= this.ghosts[i].getY()*22;
				if ((this.ghosts[i].getDir() == 0) && (this.ghosts[i].checkCell(0, this.board)))
					gY= gY - this.ghostMoveCounter*2;	
				else if ((this.ghosts[i].getDir() == 2) && (this.ghosts[i].checkCell(2, this.board)))
					gY= gY + this.ghostMoveCounter*2;
				else if ((this.ghosts[i].getDir() == 3) && (this.ghosts[i].checkCell(3, this.board)))
					gX= gX + this.ghostMoveCounter*2;
				else if ((this.ghosts[i].getDir() == 1) && (this.ghosts[i].checkCell(1, this.board)))
					gX= gX - this.ghostMoveCounter*2;
				(this.ghosts[i].getIcon()).paintIcon(this, offGr, gY + 14, gX + 21);
			}
		}
		else
			(this.player.getIcon(true)).paintIcon(this, offGr, pY + 14, pX + 21);
	}
	
	
	//returns all icons (except from food) to their starting positions
	public void resetLocations(){
		this.firstMove= true;
		this.isDead= false;
		this.ghostsOnScreen= 0;
		this.ghostBlock= new GhostCenter();
		this.playerMoveCounter= 0;
		this.ghostMoveCounter= 0;
		this.player= new RegularPacman(23, 14, this, 1, -1);
		this.ghosts= new Ghost[4];
		this.ghosts[0]= new StrongGhost(11, 14, this);
		this.ghosts[1]= new WeakGhost(14, 12, this);
		this.ghosts[2]= new StrongGhost(14, 14, this);
		this.ghosts[3]= new WeakGhost(14, 16, this);
		this.ghosts[0].setIsAlive(true, false);	//, 0
		this.ghostsOnScreen++;
		this.ghostTimer= new Timer(5000, this);
		this.deathTimer= new Timer(80, this);
		this.deathFrameCount= 0;
		this.moveTimer= new Timer(250/11, this);
		this.playerStateTimer= new Timer(10000, this);
		this.moveTimer.start();
	}
	
	
	//returns the game board's matrix
	public int[][] getBoard(){
		return this.board;
	}
	
	
	//returns the player
	public Pacman getPlayer(){
		return this.player;
	}
	
	
	//decreases food by 1
	public void decFood(){
		this.foodLeft--;
		this.parent.ateDot(this.foodLeft);
	}
	
	
	//sets the player into regular mode
		private void weakenPlayer(){
			this.playerStateTimer.stop();
			this.player= new RegularPacman(this.player.getX(), this.player.getY(), this, this.player.getFacing(), this.player.getSavedDir());
			for (int i=0; i < 4; i++){
				this.ghosts[i].setIsWeak(false);
			}
		}	
		
	
	//moves player into mighty mode
	public void mightyMode(boolean isOn){
		this.player= new MightyPacman(this.player.getX(), this.player.getY(), this, this.player.getFacing(), this.player.getSavedDir());
		this.playerStateTimer.stop();
		this.playerStateTimer.start();
		for (int i=0; i < 4; i++)
			if (this.ghosts[i].getIsAlive())
				if (i%2 == 0)
					this.ghosts[i].setIsWeak(false);
				else
					this.ghosts[i].setIsWeak(isOn);
	}
	
	
	//moves player into super mode
	public void superMode(boolean isOn){
		this.player= new SuperPacman(this.player.getX(), this.player.getY(), this, this.player.getFacing(), this.player.getSavedDir());
		this.playerStateTimer.stop();
		this.playerStateTimer.start();
		for (int i=0; i < 4; i++)
			if (this.ghosts[i].getIsAlive())
				this.ghosts[i].setIsWeak(isOn);
	}
	
	
	//moves the player of the board
	private void movePlayer(){
		if (this.playerMoveCounter == 0){
			if ((this.player.getSavedDir() != -1) && (this.player.checkCell(this.player.getSavedDir()))){
				this.player.move(this.player.getSavedDir(), false);
				this.player.setSavedDir(-1);
			}
			else
				this.player.move(this.player.getFacing(), false);
		}
		else
			setPlayerFacing();
	}
	
	
	//sets the player's facing when he needs to turn
	private void setPlayerFacing(){
		if ((this.playerMoveCounter != 0) && (this.player.getSavedDir() != -1)){
			if (!this.player.checkCell(this.player.getFacing())){
				this.player.setFacing(this.player.getSavedDir());
				this.player.setSavedDir(-1);
			}
			else {
				if (isJunction(this.player) && (this.player.checkCell(this.player.getSavedDir()))){
					this.player.setFacing(this.player.getSavedDir());
					this.player.setSavedDir(-1);	
				}
			}
		}
	}
	
	
	//tells if the player is currently in a junction
	private boolean isJunction(Pacman player){
		int x= player.getX();
		int y= player.getY();
		if ((board[x][y-1] == 0) && (board[x][y+1] == 0))
			return false;
		if ((board[x-1][y] == 0) && (board[x+1][y] == 0))
			return false;
		return true;
	}
	
	
	//moves the ghosts on the panel
	private void moveGhosts(){
		if  (this.ghostMoveCounter == 0){
			for (int i=0; i < 4; i++){
				if (this.ghosts[i].getIsAlive() && (i != 2))
					this.ghosts[i].move();
			}
			if (this.ghosts[2].getIsAlive())
				if (!didGhostsCollide())
					this.ghosts[2].move();
		}
	}
	
	
	//tells if the 2 strong ghosts have "merged" (as they use the same algorithm to move, they would not split on their own)
	private boolean didGhostsCollide(){
		if (this.ghosts[0].getIsAlive()){
			int g0X= this.ghosts[0].getX();
			int g0Y= this.ghosts[0].getY();
			int g2X= this.ghosts[2].getX();
			int g2Y= this.ghosts[2].getY();
			return ((g0X == g2X) && (g0Y == g2Y));
		}
		return false;
	}


	//releases a ghost from the ghost center into the game
	private void releaseGhosts(){
		if (this.ghostsOnScreen < 4){
			int loc= this.ghostBlock.removeGhost(this.ghosts);
			this.ghosts[loc].setIsWeak(this.ghosts[loc].isEatenBy(this.player));
			this.ghostsOnScreen++;
		}
		else
			this.ghostTimer.stop();
	}
	
	
	//kills a ghost and sends it into the ghost center
	private void killGhost(int num){
		this.ghostBlock.addGhost(this.ghosts[num], num);
		if (this.ghostsOnScreen == 4)
			this.ghostTimer.start();
		this.ghostsOnScreen--;
		this.parent.ateGhost();
	}
	
	
	//checks if the player and a ghost are on the same block
	private void checkCollision(){
		for (int i= 0; i < 4; i++){
			int pX= this.player.getX();
			int pY= this.player.getY();
			int gX= this.ghosts[i].getX();
			int gY= this.ghosts[i].getY();
			if ((pX == gX) && (pY == gY)){
				if (this.ghosts[i].isEatenBy(this.player))
					killGhost(i);
				else {
					this.isDead= true;
					this.playerStateTimer.stop();
					this.deathTimer.start();
				}
			}
		}
	}

	
	//moves all the icons on this panel
	private void moveAllIcons(){
		int playerTick= (22)/this.player.getSpeed();
		this.playerMoveCounter= (this.playerMoveCounter+1) % playerTick;
		this.ghostMoveCounter= (this.ghostMoveCounter+1) % 11;
		movePlayer();
		checkCollision();
		moveGhosts();
		checkCollision();
	}
	
	
	//runs the player death scene
	private void handleDeathScene(){
		this.moveTimer.stop();
		if (this.deathFrameCount < 9){
			this.deathFrameCount++;
		}
		else {
			this.parent.lostLife();
			this.deathTimer.stop();
			this.deathFrameCount= 0;
		}
	}
	

	@Override
	//tells what timer sent the event and operates accordingly
	public void actionPerformed(ActionEvent e) {
		if (!this.firstMove){
			if (e.getSource() == this.moveTimer)
				moveAllIcons();
			else if (e.getSource() == this.ghostTimer)
				releaseGhosts();
			else if (e.getSource() == this.deathTimer)
				handleDeathScene();
			else if (e.getSource() == this.playerStateTimer)
				weakenPlayer();
		}
	}


	@Override
	//handles the player's keystrokes
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			this.player.setSavedDir(0);
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			this.player.setSavedDir(2);
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP){
			this.player.setSavedDir(1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			this.player.setSavedDir(3);
		}
		if (this.firstMove){
			this.firstMove= false;
			this.ghostTimer.start();
		}
	}
	
	
	@Override
	//part of the KeyListener interface
	public void keyPressed(KeyEvent e) {}

	@Override
	//part of the KeyListener interface
	public void keyTyped(KeyEvent e) {}
	
	
}//MainBoard
