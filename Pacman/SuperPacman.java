package Pacman;

import javax.swing.ImageIcon;
import GameComponants.MainBoard;
import Ghost.Visitor;

/*Name: SuperPacman
propose: This class represents a super pacman
author: Gal Luvton and Daniel Sinaniev
Date Created: 27/6/2013
Last modification: 08/7/2013
*/

public class SuperPacman extends Pacman{

	/*Fields*/
	//saves all the directions of this pacman
	private final ImageIcon[] image= {new ImageIcon(SuperPacman.class.getResource("/Resources/pacman 20.gif")),
									  new ImageIcon(SuperPacman.class.getResource("/Resources/pacman 21.gif")),
									  new ImageIcon(SuperPacman.class.getResource("/Resources/pacman 22.gif")),
									  new ImageIcon(SuperPacman.class.getResource("/Resources/pacman 23.gif"))};
	
	
	/*Behavior*/
	/*Constructors*/
	//creates a new SuperPacman
	public SuperPacman(int x, int y, MainBoard game, int facing, int savedDir){
		super(x, y, game, facing, savedDir);
		}


	//returns the pacman's icon
	public ImageIcon getIcon(boolean dead) {
		if (!dead)
			return this.image[super.getFacing()];
		else
			return Pacman.DEATH;
	}


	//gets the player's speed
	public int getSpeed() {
		return 3;
	}


	//used to determine if this player killed a ghost or was killed by it
	public boolean accept(Visitor v) {
		return v.visit(this);
	}
	
}//SuperPacman
