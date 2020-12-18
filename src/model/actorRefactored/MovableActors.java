package model.actorRefactored;

import java.util.ArrayList;


public abstract class MovableActors extends IntersectingActors {
	
	/**
	 * The act method is inherited from the MovableActors class and is implemented in order for the Log to move each a certain distance each frame. 
	 * This method also receives the speed from the GameViewManager class, and moves each frame according to that speed. The method is also used to 
	 * space each one of the objects properly, in accordance to the direction they are moving in.
	 * @param now current frame of the animation
	 * @param objects ArrayList containing all the MovableActor objects
	 * @param newSpeed current speed to be used in order to move the object on the screen
	 */
	 public abstract void act(long now, ArrayList<MovableActors> objects, double newSpeed);
	 
	 /**
	  * Returns the speed of the objects at that frame in time. 
	  * @return speed of the MovableActor object.
	  */
	 public abstract double getSpeed() ;
	 
//	 public double getFirstXPositionRight() {
//			double firstXPos=0;
//			for(MovableActors actor: objects) {
//				if(this.getY()==actor.getY() && (firstXPos>actor.getX())) {
//					firstXPos=actor.getX();
//				}
//			}
//			return firstXPos;
//		}
//	 
//	 public double getFirstXPositionLeft() {
//			double firstXPos=0;
//			for(MovableActors actor: objects) {
//				if(this.getY()==actor.getY() && (firstXPos<actor.getX())) {
//					firstXPos=actor.getX();
//				}
//			}
//			return firstXPos;
//		}
}
