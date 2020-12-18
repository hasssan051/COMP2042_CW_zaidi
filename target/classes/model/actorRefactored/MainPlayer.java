package model.actorRefactored;

/**
 * This abstract class extends the IntersectingActors class and has an abstract act method. Classes that extend this class are to create a main character in
 * the game. 
 * @author HP
 *
 */
public abstract class MainPlayer extends IntersectingActors{
	
	/**
	 * Method used in order to influence MainPlayer according to the frame at the moment in time.
	 * @param now current frame of the animation. 
	 */
	public abstract void act(long now);
	
	
}
