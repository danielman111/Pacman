package Ghost;

import javax.swing.ImageIcon;
import Pacman.Pacman;

/*Name: Ghost
propose: This class represents ghost
author: Gal Luvton and Daniel Sinaniev
Date Created: 27/6/2013
Last modification: 08/7/2013
*/

public abstract class Ghost implements Visitor{
	
	/*Fields*/
	//the ghosts X location
	private int x;
	//the ghosts Y location
	private int y;
	//tells if this ghost is in "weak" state
	private boolean weak;
	//tells if the ghost is alive
	private boolean isAlive;
	//remembers the last direction the ghost moved to
	private int lastDir;
	
	
	/*Behavior*/
	/*Constructors*/
	//creates a new ghost
	public Ghost(int x, int y){
		this.x= x;
		this.y= y;
		this.weak= false;
		this.isAlive= false;
	}
	
	
	//moves the ghost
	public abstract void move();
	
	//returns the ghost's icon
	public abstract ImageIcon getIcon();
	
	
	//returns the ghost's X location
	public int getX(){
		return this.x;
	}
	
	
	//returns the ghost's Y location
	public int getY(){
		return this.y;
	}
	
	
	//sets the ghost's X location
	public void setX(int x){
		this.x= x;
	}
	
	
	//sets the ghost's Y location
	public void setY(int y){
		this.y= y;
	}
	
	
	//returns the ghost's last direction
	public int getDir(){
		return this.lastDir;
	}
	
	
	//sets the ghost's X last direction
	public void setDir(int dir){
		this.lastDir= dir;
	}
	
	
	//tells if the ghost is weak or not
	public boolean getIsWeak(){
		return this.weak;
	}
	
	
	//sets the ghost's 'weak' state
	public void setIsWeak(boolean state){
		this.weak= state;	
	}
	
	
	//returns if this ghost is alive
	public boolean getIsAlive(){
		return this.isAlive;
	}
	
	
	//sets if this ghost is alive
	public void setIsAlive(boolean state, boolean isWeak){
		this.isAlive= state;
		this.weak= isWeak;
	}

	
	//checks if this cell is a tunnel (warp points at the sides of the game board)
	private boolean isTunnel(int x, int y){
		return ((x == 14) && ((y == 5) || (y == 22)));
	}
	
	
	//checks if this cell is a junction
	public boolean isJunction(int[][] gameBoard){
		if ((gameBoard[this.x][this.y-1] == 0) && (gameBoard[this.x][this.y+1] == 0))
			return false;
		if ((gameBoard[this.x-1][this.y] == 0) && (gameBoard[this.x+1][this.y] == 0))
			return false;
		return true;
	}
	
	
	//checks if this is a valid cell to move into
	public boolean checkCell(int dir, int[][] gameBoard){
		try {
		if (dir == 0)
			return ((!isTunnel(this.x, this.y-1)) && (gameBoard[this.x][this.y-1] != 0));
		else if (dir == 1)
			return ((!isTunnel(this.x-1, this.y)) && (gameBoard[this.x-1][this.y] != 0));
		else if (dir == 2)
			return ((!isTunnel(this.x, this.y+1)) && (gameBoard[this.x][this.y+1] != 0));
		else
			return ((!isTunnel(this.x+1, this.y)) && (gameBoard[this.x+1][this.y] != 0));
		}
		catch (Exception e){
			return false;
		}
	}
	

	//tells if this ghost is eaten by pacman
	public boolean isEatenBy(Pacman player){
		return player.accept(this);
	}
	
	
}//Ghost
