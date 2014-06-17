package Pacman;

import javax.swing.ImageIcon;
import GameComponants.MainBoard;
import Ghost.Visitor;

/*Name: RegularPacman
propose: This class represents a regular pacman
author: Gal Luvton and Daniel Sinaniev
Date Created: 27/6/2013
Last modification: 08/7/2013
*/

public class RegularPacman extends Pacman{

	/*Fields*/
	//saves all the directions of this pacman
	private final ImageIcon[] image= {new ImageIcon(RegularPacman.class.getResource("/Resources/pacman 00.gif")),
									  new ImageIcon(RegularPacman.class.getResource("/Resources/pacman 01.gif")),
									  new ImageIcon(RegularPacman.class.getResource("/Resources/pacman 02.gif")),
									  new ImageIcon(RegularPacman.class.getResource("/Resources/pacman 03.gif"))};
	
	
	/*Behavior*/
	/*Constructors*/
	//creates a new RegularPacman
	public RegularPacman(int x, int y, MainBoard game, int facing, int savedDir){
		super(x, y, game, facing, savedDir);
	}
	
	
	//returns the pacman's icon
	public ImageIcon getIcon(boolean dead){
		if (!dead)
			return this.image[super.getFacing()];
		else
			return Pacman.DEATH;
	}

	
	//gets the player's speed
	public int getSpeed() {
		return 2;
	}

	
	//used to determine if this player killed a ghost or was killed by it
	public boolean accept(Visitor v) {
		return v.visit(this);
	}

}//RegularPacman
