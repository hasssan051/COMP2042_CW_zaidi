package model;

import java.util.ArrayList;

import javafx.scene.image.Image;
import model.ActorResources.ActorComponents;

public class Turtle extends MovableActors{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	
	private static final String TURTLEANIMATION_1="file:src/model/ActorResources/TurtleAnimation1.png";
	private static final String TURTLEANIMATION_2="file:src/model/ActorResources/TurtleAnimation2.png";
	private static final String TURTLEANIMATION_3="file:src/model/ActorResources/TurtleAnimation3.png";
	
	
	ActorComponents oBject =ActorComponents.TURTLE;
	ArrayList<MovableActors> objects;
	private int spacing= 100;
	private double speed=0;
	boolean bool = true;
	@Override
	public void act(long now, ArrayList<MovableActors> objects,double newSpeed) {
		double firstXPos=0;
		this.objects=objects;
		speed=newSpeed;
		//System.out.println("the speed of the turtle is"+this.speed);
		
		
				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		
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
				
			
		if (getX()<-300 && speed<0)
			if(firstXPos<0) {
				setX(600+firstXPos+oBject.getSize()+spacing);
			}else {
				setX(600+oBject.getSize()+spacing);
			}
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
	
	public double getFirstXPositionRight() {
		double firstXPos=0;
		for(MovableActors actor: objects) {
			if(getY()==actor.getY() && (firstXPos>actor.getX())) {
				firstXPos=actor.getX();
			}
		}
		return firstXPos;
	}
 
 public double getFirstXPositionLeft() {
		double firstXPos=0;
		for(MovableActors actor: objects) {
			if(getY()==actor.getY() && (firstXPos<actor.getX())) {
				firstXPos=actor.getX();
			}
		}
		return firstXPos;
	}
	@Override
	public double getSpeed() {
		
		return this.speed;
	}
	
	
	
	
	
}
