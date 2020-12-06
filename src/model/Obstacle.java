package model;

import java.util.ArrayList;

import javafx.scene.image.Image;
import model.ActorResources.ActorComponents;

public class Obstacle extends Actor{
	//int speedMultiplier;
	private int speed=0;
	private ArrayList<Actor> objects;
	ActorComponents oBject;
	private int spacing=100;
	
	@Override
	public void act(long now, ArrayList<Actor> objects, int speedMultiplier) {
		this.objects= objects;
		
		double firstXPos=getFirstXPosition();
		move(speed , 0);
		if (getX() > 600 && speed>0)
			if(firstXPos<0) {
			setX(firstXPos-oBject.getWidth()-spacing);
			} else {
				setX(-oBject.getWidth()-spacing);
			}
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	public Obstacle(ActorComponents object, int xpos, int ypos, int s) {	
		this.oBject=object;
		setImage(new Image(oBject.getUrlLeft(),oBject.getWidth() ,oBject.getHeight(), true, true));
		setX(xpos);
		setY(ypos);
		this.speed=s;
		//increaseSpeed=this.speed;
		
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
