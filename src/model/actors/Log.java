package model.actors;

import java.util.ArrayList;

import javafx.scene.image.Image;
import model.ActorResources.ActorComponents;
import model.actorRefactored.MovableActors;
/**
 * Extends MovableActors class, and an object of this class is a single Log. Frogger or any PlayerActor object can hitch a ride on a Log.
 * This class implements the act method and is able to move each method according to the inputs received. The objects created are also 
 * positioned with proper spacing. 
 * @author HP
 *
 */

public class Log extends MovableActors{
	
	private double speed=0;
	ArrayList<MovableActors> objects;
	ActorComponents oBject;
	private int spacing=100;


	
	public void act(long now,ArrayList<MovableActors> objects,double newSpeed) {
		this.objects= objects;
		this.speed=newSpeed;
		double firstXPos=0;
		
		if(speed>0) {
			firstXPos= getFirstXPositionRight();
		}
		else {
			firstXPos= getFirstXPositionLeft();
		}
		move(speed , 0);
		if (getX()>600 && speed>0)
			if(firstXPos<0) {
				setX(firstXPos-oBject.getSize()-spacing);
			}else {
				setX(-oBject.getSize()-spacing);
			}
				
			
		if (getX()<-300+spacing && speed<0)
			if(firstXPos<0) {
				setX(600+firstXPos+oBject.getSize()+spacing);
			}else {
				setX(600+oBject.getSize()+spacing);
			}
			//setX(700);
	}
	
	/**
	 * The constructor receives an ActorComponents Object from the gamesetter which it uses in order to create the object according to its specifications 
	 * in ActorComponents Enum. 
	 * @param object ActorComponents object, which specifies exactly which sort of log is needed to be made
	 * @param xpos initial position of the object on the x axis.
	 * @param ypos position of the object on y axis (the row in which the object will fit into). 
	 * @param s initial speed with which the object will move on the screen.
	 */

	public Log(ActorComponents object, int xpos, int ypos, double s) {
		this.oBject = object;
		setImage(new Image(object.getObject(), oBject.getSize(),oBject.getSize(), true, true));
		setX(xpos);
		setY(ypos);
		this.speed = s;	
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
	public boolean getLeft() {
		return speed < 0;
	}
	
	public double getSpeed() {
		return this.speed;
	}


}
