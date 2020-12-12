package model;

import java.util.ArrayList;

import javafx.scene.image.Image;
import model.ActorResources.ActorComponents;

public class Obstacle extends MovableActors{
	//int speedMultiplier;
	private double speed=0;
	ArrayList<MovableActors> objects;
	ActorComponents oBject;
	private int spacing=100;
	
	@Override
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
				setX(firstXPos-oBject.getWidth()-spacing);
			}else {
				setX(-oBject.getWidth()-spacing);
			}
				
			
		if (getX()<-300 && speed<0)
			if(firstXPos<0) {
				setX(firstXPos+oBject.getWidth()+spacing);
			}else {
				setX(600);
			}
	}
	
	public Obstacle(ActorComponents object, int xpos, int ypos, int s) {	
		this.oBject=object;
		setImage(new Image(oBject.getUrlLeft(),oBject.getWidth() ,oBject.getHeight(), true, true));
		setX(xpos);
		setY(ypos);
		this.speed=s;
		//increaseSpeed=this.speed;
		
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
	
	public ActorComponents getObstacle() {
		return oBject;
	}
}
