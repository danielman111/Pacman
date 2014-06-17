package Pacman;

import Ghost.Visitor;

/*Name: Visited
propose: This class represents the visitor pattern
author: Gal Luvton and Daniel Sinaniev
Date Created: 27/6/2013
Last modification: 08/7/2013
*/

public interface Visited {
	
	//helps determine the instance of the class given to it
	public boolean accept(Visitor v);

}//Visited
