package GameComponants;

import java.util.Vector;
import Ghost.Ghost;

/*Name: GhostCenter
propose: This class is the ghost's square in the middle of the board
author: Gal Luvton and Daniel Sinaniev
Date Created: 27/6/2013
Last modification: 08/7/2013
*/

public class GhostCenter {

	/*Fields*/
	//keeps the number of ghosts in this area
	private int numOfGhosts;
	//keeps the ghost's numbers in the order they entered
	private Vector<Integer> ghostNums;
	
	
	/*Behavior*/
	/*Constructors*/
	//creates a new GhostCenter
	public GhostCenter(){
		this.numOfGhosts= 3;
		this.ghostNums= new Vector<Integer>();
		this.ghostNums.add(new Integer(1));
		this.ghostNums.add(new Integer(2));
		this.ghostNums.add(new Integer(3));
	}
	
	
	//adds ghost 'g' to this center
	public void addGhost(Ghost g, int ghostNum){
		g.setIsAlive(false, false);
		if (numOfGhosts == 0){
			g.setX(14);
			g.setY(16);
		}
		else if (numOfGhosts == 1){
			g.setX(14);
			g.setY(14);
		}
		else if (numOfGhosts == 2){
			g.setX(14);
			g.setY(12);
		}
		else if (numOfGhosts == 3){
			g.setX(16);
			g.setY(14);
		}
		this.ghostNums.add(new Integer(ghostNum));
		this.numOfGhosts++;
	}
	
	
	//removes  ghost 'g' from this center
	public int removeGhost(Ghost[] g){
		int loc;
		if (this.numOfGhosts == 4)
			loc= this.ghostNums.remove(3);
		else
			loc= this.ghostNums.remove(0);
		g[loc].setX(11);
		g[loc].setY(14);
		if (Math.random() > 0.5)
			g[loc].setDir(0);
		else
			g[loc].setDir(2);
		g[loc].setIsAlive(true, false);
		this.numOfGhosts--;
		return loc;
	}
	
	
}//GhostCenter
