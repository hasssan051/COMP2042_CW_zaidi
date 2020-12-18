package model.actorRefactored;

import model.actors.Frogger;

/**
 * This PlayerFactory class can be used to extend the game by adding in new MainPlayer with different functionalities. It can also be used in order to make
 * the game possibly double player.
 * @author HP
 *
 */
public class PlayerFactory {
	
	/**
	 * Creates a player.
	 * @param mainActor Is an ActorsEnum object
	 * @return returns the specific MainPlayer object required by a class.
	 */
	public static MainPlayer createPlayer(PlayerEnum mainActor) {
		
		MainPlayer mainPlayer=null;
		switch(mainActor) {
		case FROGGER: 
			mainPlayer= new Frogger();
			break;
		default:
			mainPlayer= null;
		}
		return mainPlayer;
	}
}
