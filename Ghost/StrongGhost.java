package Ghost;

import java.util.Vector;

import javax.swing.ImageIcon;
import GameComponants.MainBoard;
import Pacman.MightyPacman;
import Pacman.RegularPacman;
import Pacman.SuperPacman;

/*Name: StrongGhost
propose: This class represents a strong ghost
author: Gal Luvton and Daniel Sinaniev
Date Created: 27/6/2013
Last modification: 08/7/2013
*/

public class StrongGhost extends Ghost{
	
	/*Fields*/
	//the game board
	private MainBoard game;
	//the ghost's icon when not in 'weak' state
	private final ImageIcon strongGhost= new ImageIcon(WeakGhost.class.getResource("/Resources/strong ghost.gif"));
	//the ghost's icon when in 'weak' state
	private final ImageIcon volGhost= new ImageIcon(WeakGhost.class.getResource("/Resources/vol ghost.gif"));
	
	
	/*Behavior*/
	/*Constructors*/
	//creates a new StrongGhost
	public StrongGhost(int x, int y, MainBoard game){
		super(x, y);
		this.game= game;
	}
	
	
	//returns the ghost's icon
	public ImageIcon getIcon(){
		if (super.getIsWeak())
			return this.volGhost;
		else
			return this.strongGhost;
	}
	

	//returns an vector with the numbers 0-3 in random order, without the last direction
	private Vector<Integer> moveArr(int lastDir){
		Vector<Integer> ans= new Vector<Integer>();
		int xDis= super.getX() - this.game.getPlayer().getX();
		int yDis= super.getY() - this.game.getPlayer().getY();
		if (Math.abs(xDis) <= Math.abs(yDis))
			moveOnX(ans, xDis, yDis);
		else
			moveOnY(ans, xDis, yDis);
		ans.remove(new Integer((lastDir+2)%4));
		return ans;
	}

	
	//moves the ghost
	public void move(){
		if (super.isJunction(this.game.getBoard())){
			Vector<Integer> tempVec= moveArr(this.getDir());
			boolean moved= false;
			int ind= 0;
			while (!moved){	//trys to go to all the directions in the vector
				if (super.checkCell((tempVec.elementAt(ind)).intValue(), this.game.getBoard())){
					move((tempVec.elementAt(ind)).intValue());
					moved= true;
				}
				else
					ind++;
			}
		}
		else
			move(super.getDir());
	}
	
	
	//moves the ghost in this direction
	private void move(int dir){
		if ((dir == 0) && (super.getDir() != 2)){
			super.setY(getY()-1);
			super.setDir(dir);
		}
		else if ((dir == 1) && (super.getDir() != 3)){
			super.setX(getX()-1);
			super.setDir(dir);
		}
		else if ((dir == 2) && (super.getDir() != 0)){
			super.setY(getY()+1);
			super.setDir(dir);
		}
		else if ((dir == 3) && (super.getDir() != 1)){
			super.setX(getX()+1);
			super.setDir(dir);
		}
	}
	
	
	//helps creating the moveVector, simulates moving on the X axis
	private void moveOnX(Vector<Integer> ans, int xDis, int yDis){
		if (xDis >= 0){
			ans.add(1);
			if (yDis >= 0){
				ans.add(0);
				ans.add(3);
				ans.add(2);
			}
			else {
				ans.add(2);
				ans.add(3);
				ans.add(0);
			}
		}
		else {
			ans.add(3);
			if (yDis >= 0){
				ans.add(0);
				ans.add(1);
				ans.add(2);
			}
			else {
				ans.add(2);
				ans.add(1);
				ans.add(0);
			}
		}
	}
	
	
	//helps creating the moveVector, simulates moving on the Y axis
	private void moveOnY(Vector<Integer> ans, int xDis, int yDis){
		if (yDis >= 0){
			ans.add(0);
			if (xDis >= 0){
				ans.add(1);
				ans.add(2);
				ans.add(3);
			}
			else {
				ans.add(3);
				ans.add(2);
				ans.add(1);
			}
		}
		else {
			ans.add(2);
			if (xDis >= 0){
				ans.add(1);
				ans.add(0);
				ans.add(3);
			}
			else {
				ans.add(3);
				ans.add(0);
				ans.add(1);
			}
		}
	}
		
	
	//is used to tell if this ghost is eaten by pacman
	public boolean visit(RegularPacman pac) {
		return false;
	}


	//is used to tell if this ghost is eaten by pacman
	public boolean visit(MightyPacman pac) {
		return false;
	}


	//is used to tell if this ghost is eaten by pacman
	public boolean visit(SuperPacman pac) {
		return true;
	}
	
	
}//StrongGhost
