package model;

import java.util.ArrayList;

import javafx.scene.image.Image;
import model.ActorResources.ActorComponents;

public class Turtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	
	private static final String TURTLEANIMATION_1="file:src/model/ActorResources/TurtleAnimation1.png";
	private static final String TURTLEANIMATION_2="file:src/model/ActorResources/TurtleAnimation2.png";
	private static final String TURTLEANIMATION_3="file:src/model/ActorResources/TurtleAnimation3.png";
	
	
	ActorComponents oBject =ActorComponents.TURTLE;
	ArrayList<Actor> objects;
	private int spacing= 100;
	private int speed=0;
	boolean bool = true;
	@Override
	public void act(long now, ArrayList<Actor> objects, int speedMultiplier) {
		this.objects=objects;
		double firstXPos= getFirstXPosition();
				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			if(firstXPos<0) {
				setX(firstXPos-oBject.getWidth()-spacing);
				} else {
					setX(-oBject.getWidth()-spacing);
				}
		if (getX() < -75 && speed<0)
			setX(600);
	}
	public Turtle(int xpos, int ypos, int s) {
		turtle1 = new Image(TURTLEANIMATION_1, oBject.getWidth(), oBject.getHeight(), true, true);
		turtle2 = new Image(TURTLEANIMATION_2, oBject.getWidth(), oBject.getHeight(), true, true);
		turtle3 = new Image(TURTLEANIMATION_3, oBject.getWidth(), oBject.getHeight(), true, true);
		setX(xpos);
		setY(ypos);
		this.speed = s;
		setImage(turtle2);
	}
	
	protected double getFirstXPosition() {
		double firstXPos=0;
		for(Actor actor: objects) {
			if(getY()==actor.getY() && (firstXPos>actor.getX())) {
				firstXPos=actor.getX();
			}
		}
		return firstXPos;
	}
	
	
	
	
	
}
