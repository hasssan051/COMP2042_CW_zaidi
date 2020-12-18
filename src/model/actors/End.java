package model.actors;


import javafx.scene.image.Image;
import model.actorRefactored.IntersectingActors;
/**
 * Class is used in order to displays ends on the screen. This class extends the IntersectingActors class since it has to be interacting with frogger
 * object. It can be intersected by frogger. 
 * @author HP
 *
 */

public class End extends IntersectingActors{
	private boolean activated = false;
	
	private static final String END_URL="file:src/model/ActorResources/End.png";
	private static final String SET_END_URL="file:src/model/ActorResources/FrogEnd.png";
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image(END_URL, 60, 60, true, true));
	}
	
	/**
	 * Method used to set image of the End ImageView to show that end has been completed. This method also sets the activated field of the object to 
	 * true.
	 */
	public void setEnd() {
		setImage(new Image(SET_END_URL, 70, 70, true, true));
		activated = true;
	}
	/**
	 * Method used in order to reset the End to show that the End is not filled yet. It also sets the activated field of the object to false.
	 */
	public void unsetEnd() {
		setImage(new Image(END_URL, 60, 60, true, true));
		activated=false;
	}
	/**
	 * Method checks whether the activated field of an end Object is true or false.
	 * @return returns the value of the activated field of the object.
	 */
	public boolean isActivated() {
		return activated;
	}

	

}
