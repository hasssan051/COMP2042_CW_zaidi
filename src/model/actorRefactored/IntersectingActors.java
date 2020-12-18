package model.actorRefactored;

import java.util.ArrayList;

import javafx.scene.image.ImageView;
import view.World;

/**
 * The IntersectingActors class extends the ImageView class and implements ActorsInterface. It is used by any object in the game that intersect with another
 * object. This class is created so that this program can be extended to add objects in the game that cannot be intersected with. 
 * @author HP
 *
 */
public class IntersectingActors extends ImageView implements ActorsInterface{
	/**
	 * The move method sets the X and Y coordinates of any ImageView according to the parameters it receives.
	 * @param dx amount of distance to be moved on the x axis
	 * @param dy amount of distance to moved on the y axis
	 */
	
	public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
	
	public <A extends IntersectingActors> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
	        ArrayList<A> someArray = new ArrayList<A>(); 
	        for (A actor: getWorld().getObjects(cls)) {
	            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
	                someArray.add(actor);
	            }
	        }
	        return someArray;
	    }
	
	
	public World getWorld() {
		return (World) getParent();
	}
	
	
}
