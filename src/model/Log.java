package model;

import java.util.ArrayList;

import javafx.scene.image.Image;
import model.ActorResources.ActorComponents;

public class Log extends Actor{
	
	private double speed=0;
	private ArrayList<Actor> objects;
	ActorComponents oBject;
	private int spacing=100;
	int speedMultiplier;
	
	@Override
	public void act(long now,ArrayList<Actor> objects,int speedMultiplier) {
		this.objects= objects;
		this.speedMultiplier= speedMultiplier;
		double firstXPos= getFirstXPosition();
		
		move(speed , 0);
		if (getX()>600 && speed>0)
			if(firstXPos<0) {
				setX(firstXPos-oBject.getSize()-spacing);
			}else {
				setX(-oBject.getSize()-spacing);
			}
				
			
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	

	public Log(ActorComponents object, int xpos, int ypos, double s) {
		this.oBject = object;
		setImage(new Image(object.getObject(), oBject.getSize(),oBject.getSize(), true, true));
		setX(xpos);
		setY(ypos);
		this.speed = s;	
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
	public boolean getLeft() {
		return speed < 0;
	}


}
