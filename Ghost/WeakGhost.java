package Ghost;

import javax.swing.ImageIcon;
import GameComponants.MainBoard;
import Pacman.MightyPacman;
import Pacman.RegularPacman;
import Pacman.SuperPacman;

/*Name: WeakGhost
propose: This class represents weak ghost
author: Gal Luvton and Daniel Sinaniev
Date Created: 27/6/2013
Last modification: 08/7/2013
*/

public class WeakGhost extends Ghost{
	
	/*Fields*/
	//the game board
	private MainBoard game;
	//the ghost's icon when not in 'weak' state
	private final ImageIcon weakGhost= new ImageIcon(WeakGhost.class.getResource("/Resources/weak ghost.gif"));
	//the ghost's icon when in 'weak' state
	private final ImageIcon volGhost= new ImageIcon(WeakGhost.class.getResource("/Resources/vol ghost.gif"));
	
	
	/*Behavior*/
	/*Constructors*/
	//creates a new WeakGhost
	public WeakGhost(int x, int y, MainBoard game){
		super(x, y);
		this.game= game;
	}

	
	//returns the ghost's icon
	public ImageIcon getIcon(){
		if (super.getIsWeak())
			return this.volGhost;
		else
			return this.weakGhost;
	}
	
	
	//returns an array with the numbers 0-3 in random order
	private int[] randArr(){
		int[] ans= {0, 1, 2, 3};
		for (int i=0; i < 4; i++){
			int rand= ((int)(Math.random()*4));
			int temp= ans[rand];
			ans[rand]= ans[3-i];
			ans[3-i]= temp;		
		}
		return ans;
	}
	
	
	//moves the ghost
	public void move(){
		if (super.isJunction(this.game.getBoard())){
			int[] dirArr= randArr();
			boolean moved= false;
			int ind= 0;
			while (!moved){	//trys to go to all the directions in the array
				if (super.checkCell(dirArr[ind], this.game.getBoard())){
					move(dirArr[ind]);
					moved= true;
				}
				else
					ind++;
			}
		}
		else {
			move(super.getDir());
		}
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


	//is used to tell if this ghost is eaten by pacman
	public boolean visit(RegularPacman pac) {
		return false;
	}


	//is used to tell if this ghost is eaten by pacman
	public boolean visit(MightyPacman pac) {
		return true;
	}


	//is used to tell if this ghost is eaten by pacman
	public boolean visit(SuperPacman pac) {
		return true;
	}

	
}//WeakGhost