package model.actors;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;
import model.ActorResources.ActorComponents;
import model.actorRefactored.MovableActors;

/**
 * This class extends the abstract class MovableActors and is used to create turtles that can sink under the water. 
 * The class implements the act method and is able to move each method according to the inputs received. The objects created are also positioned with proper spacing.
 * The class also contains animations for turtles, so that it looks like they are moving.
 * @author HP
 * @author HP
 *
 */
public class WetTurtle extends MovableActors{
	
	ActorComponents actorObject =ActorComponents.WETTURTLE;
	
	Image turtle1 = new Image(actorObject.getUrlAnimation1(), actorObject.getWidth(), actorObject.getHeight(), true, true);
	Image turtle2 = new Image(actorObject.getUrlAnimation2(), actorObject.getWidth(), actorObject.getHeight(), true, true);
	Image turtle3 = new Image(actorObject.getUrlAnimation3(),actorObject.getWidth(), actorObject.getHeight(), true, true);
	Image turtle4 = new Image(actorObject.getUrlAnimation4(),actorObject.getWidth(), actorObject.getHeight(), true, true);
	
	KeyFrame firstAnim  = new KeyFrame(Duration.seconds(1),e ->sunk=false, new KeyValue(this.imageProperty(),turtle1));
	KeyFrame secondAnim = new KeyFrame(Duration.seconds(1.5),e ->sunk=false, new KeyValue(this.imageProperty(),turtle2));
	KeyFrame thirdAnim  = new KeyFrame(Duration.seconds(2), e ->sunk=true,new KeyValue(this.imageProperty(),turtle3));
	KeyFrame fourthAnim = new KeyFrame(Duration.seconds(1.5),e ->sunk=false, new KeyValue(this.imageProperty(),turtle4));
	//KeyFrame keyframe= new KeyFrame(Duration.seconds(2), ); 
	
	Timeline timeline = new Timeline();
	
	private double speed=0;
	private boolean sunk = false;
	private int spacing= 100;
	
	ArrayList<MovableActors> objects;
	
	
	
	public void act(long now,ArrayList<MovableActors> objects, double newSpeed) {
		double firstXPos=0;
		this.objects=objects;
		this.speed= newSpeed;
		
		//sunk=false;
		showTurtleAnimation();
			
		if(speed>0) {
			firstXPos= getFirstXPositionRight();
		}
		else {
			firstXPos= getFirstXPositionLeft();
		}
		move(speed , 0);
		if (getX()>600 && speed>0)
			if(firstXPos<0) {
				setX(firstXPos-actorObject.getSize()-spacing);
			}else {
				setX(-actorObject.getSize()-spacing);
			}
				
			
		if (getX()<-300 && speed<0)
			if(firstXPos<0) {
				setX(600+firstXPos+actorObject.getSize()+spacing);
			}else {
				setX(600+actorObject.getSize()+spacing);
			}
	}
	/**
	 * Constructor used to create WetTurtle Object and initialize its fields.
	 * @param xpos initial position of object on the x axis.
	 * @param ypos position of the object on y axis (the row in which the object will fit into). 
	 * @param s initial speed of the object.
	 */
	public WetTurtle(int xpos, int ypos, int s) {
		setX(xpos);
		setY(ypos);
		this.speed = s;
		setImage(turtle2);
	}
	
	/**
	 * Method used to checked whether the WetTurtle object is under water or not.
	 * @return returns the boolean field sunk
	 */
	public boolean isSunk() {
		return sunk;
	}
	
	/**
	 * This method is used to display the Turtle animation.
	 */
	private void showTurtleAnimation() {		
		timeline.getKeyFrames().addAll(firstAnim,secondAnim,thirdAnim,fourthAnim); 
		timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
		
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
	
	
	
	
	
	
}
