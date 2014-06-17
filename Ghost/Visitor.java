package Ghost;

import Pacman.MightyPacman;
import Pacman.RegularPacman;
import Pacman.SuperPacman;

/*Name: Visitor
propose: This class represents the visitor pattern
author: Gal Luvton and Daniel Sinaniev
Date Created: 27/6/2013
Last modification: 08/7/2013
*/

public interface Visitor {

	
	//visits the RegularPacman class
	public boolean visit(RegularPacman pac);
	
	//visits the MightyPacman class
	public boolean visit(MightyPacman pac);
	
	//visits the SuperPacman class
	public boolean visit(SuperPacman pac);
	
}//Visitor
