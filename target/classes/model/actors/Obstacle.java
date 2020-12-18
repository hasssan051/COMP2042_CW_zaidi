package model.actors;

import java.util.ArrayList;

import javafx.scene.image.Image;
import model.ActorResources.ActorComponents;
import model.actorRefactored.MovableActors;

/**
 * Extending the MovableActors class, the Obstacle class is used to create obstacles that will kill Frogger object, if it were to collide with them. 
 * This class is used to create crocodiles, cars and trucks in the game. The class implements the act method and is able to move each method according 
 * to the inputs received. The objects created are also positioned with proper spacing. 
 * @author HP
 *
 */

public class Obstacle extends MovableActors{
	
	private double speed=0;
	ArrayList<MovableActors> objects;
	ActorComponents actorObject;
	private int spacing=100;
	
	public void act(long now, ArrayList<MovableActors> objects, double newSpeed) {
		double firstXPos=0;
		
		this.objects= objects;
		
		this.speed=newSpeed;
		
		if(speed>0) {
			firstXPos= getFirstXPositionRight();
		}
		else {
			firstXPos= getFirstXPositionLeft();
		}
		move(speed , 0);
		if (getX()>600 && speed>0)
			if(firstXPos<0) {
				setX(firstXPos-actorObject.getWidth()-spacing);
			}else {
				setX(-actorObject.getWidth()-spacing);
			}
				
			
		if (getX()<-300 && speed<0)
			if(firstXPos<0) {
				setX(firstXPos+actorObject.getWidth()+spacing);
			}else {
				setX(600);
			}
	}
	
	/**
	 * The constructor receives an ActorComponents Object from the GameSetter class which it uses in order to create the object according to its specifications 
	 * in ActorComponents Enum. 
	 * @param object  object ActorComponents object, which specifies exactly which sort of obstacle is to be created.
	 * @param xpos initial position of the object on the x axis.
	 * @param ypos position of the object on y axis (the row in which the object will fit into). 
	 * @param s initial speed with which the object will move on the screen.
	 */
	public Obstacle(ActorComponents object, int xpos, int ypos, int s) {	
		this.actorObject=object;
		setImage(new Image(actorObject.getUrlLeft(),actorObject.getWidth() ,actorObject.getHeight(), true, true));
		setX(xpos);
		setY(ypos);
		this.speed=s;
		//increaseSpeed=this.speed;
		
	}
	
	/**
	 * This method is inherited from the MovingActors abstract class and is implemented in order to get the x position of the first Log created. It checks 
	 * for the objects in the same row and sets the firstXPos variable to the x position of the first object in the row from the objects ArrayList.
	 * @return position of the first log is returned
	 */
	public double getFirstXPositionRight() {
		double firstXPos=0;
		for(MovableActors actor: objects) {
			if(getY()==actor.getY() && (firstXPos>actor.getX())) {
				firstXPos=actor.getX();
			}
		}
		return firstXPos;
	}
	/**
	 * This method is inherited from the MovingActors abstract class and is implemented in order to get the x position of the first Log created. It checks 
	 * for the objects in the same row and sets the firstXPos variable to the x position of the first object in the row from the objects ArrayList.
	 * @return position of the first log is returned
	 */
	public double getFirstXPositionLeft() {
		double firstXPos=0;
		for(MovableActors actor: objects) {
			if(getY()==actor.getY() && (firstXPos<actor.getX())) {
				firstXPos=actor.getX();
			}
		}
		return firstXPos;
	}
	
	public double getSpeed() {
		return this.speed;
	}
	
	/**
	 * Method used to get what type of obstacle is being created.
	 * @return returns an ActorComponent object
	 */
	public ActorComponents getObstacle() {
		return actorObject;
	}
}
