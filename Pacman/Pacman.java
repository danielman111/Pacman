package Pacman;

import javax.swing.ImageIcon;
import GameComponants.MainBoard;

/*Name: Pacman
propose: This class represents pacman
author: Gal Luvton and Daniel Sinaniev
Date Created: 27/6/2013
Last modification: 08/7/2013
*/

public abstract class Pacman implements Visited{
		
	/*Fields*/
	//the X location of this pacman
	private int x;
	//the Y location of this pacman
	private int y;
	//the direction this pacman is facing (0-left ,1-up, 2-right ,3-down) 
	private int facing;	
	//the last direction that was entered, and has yet to move there
	private int savedDir;
	//the game
	private MainBoard game;
	//the death animation
	protected static final ImageIcon DEATH= new ImageIcon(Pacman.class.getResource("/Resources/death.gif"));
	
	
	/*Behavior*/
	/*Constructors*/
	//creates a new pacman
	public Pacman(int x, int y, MainBoard game, int facing, int savedDir){
		this.x= x;
		this.y= y;
		this.facing= facing;
		this.savedDir= savedDir;
		this.game= game;
	}
	
	
	//returns the pacman's icon
	public abstract ImageIcon getIcon(boolean dead);
	
	//gets the player's speed
	public abstract int getSpeed();
	
	
	//returns the X location of this pacman
	public int getX(){
		return this.x;
	}
	
	
	//returns the Y location of this pacman
	public int getY(){
		return this.y;
	}
	
	
	//returns this pacman's facing
	public int getFacing(){
		return this.facing;
	}
	
	
	//sets this pacman's facing
	public void setFacing(int f){
		this.facing= f;
	}
	
	
	//returns this pacman's saved direction
	public int getSavedDir(){
		return this.savedDir;
	}
	
	
	//sets this pacman's saved direction
	public void setSavedDir(int dir){
		this.savedDir= dir;
	}
	
	
	//moves the pacman in the 'dir' direction, and takes into account if the player told it to move there or not
	public void move(int dir, boolean didPlayerSend){
		int[][] gameBoard= game.getBoard();
		if (checkCell(dir))
			moveToCell(dir, gameBoard);
		else if (didPlayerSend)
			this.savedDir= dir;
		else {
			if (this.savedDir != dir)
				this.savedDir= dir;
			else
				this.savedDir= -1;
		}
	}
	
	
	//moves the playing in the direction given
	private void moveToCell(int dir, int[][] gameBoard){
		if (dir == 0){
			if (gameBoard[this.x][this.y-1] == 5)
				this.y= 27;
			else
				this.y--;
		}
		else if (dir == 1)
			this.x--;
		else if (dir == 2)
			if (gameBoard[this.x][this.y+1] == 6)
				this.y= 0;
			else
				this.y++;
		else if (dir == 3)
			this.x++;
		else
			return;
		this.facing= dir;
		if (gameBoard[x][y] == 1){	//eats whats ever on the board at this spot
			gameBoard[x][y]= 4;
			game.decFood();
		}
		else if (gameBoard[x][y] == 2){
			gameBoard[x][y]= 4;
			this.game.mightyMode(true);
		}
		else if (gameBoard[x][y] == 3){
			gameBoard[x][y]= 4;
			this.game.superMode(true);
		}	
	}
	
	
	//checks if the cell in the given direction can be moved into
	public boolean checkCell(int dir){
		int[][] gameBoard= game.getBoard();
		try {
		if (dir == 0)
			return (gameBoard[this.x][this.y-1] != 0);
		else if (dir == 1)
			return (gameBoard[this.x-1][this.y] != 0);
		else if (dir == 2)
			return (gameBoard[this.x][this.y+1] != 0);
		else
			return (gameBoard[this.x+1][this.y] != 0);
		}
		catch (Exception e){
			return false;
		}
	}

}//Pacman
