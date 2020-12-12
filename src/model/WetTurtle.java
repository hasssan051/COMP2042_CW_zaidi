package model;

import java.util.ArrayList;

import javafx.scene.image.Image;
import model.ActorResources.ActorComponents;

public class WetTurtle extends MovableActors{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	
	private double speed=0;
	boolean sunk = false;
	
	ActorComponents oBject =ActorComponents.WETTURTLE;
	ArrayList<MovableActors> objects;
	private int spacing= 100;
	
	@Override
	public void act(long now,ArrayList<MovableActors> objects, double newSpeed) {
		double firstXPos=0;
		this.objects=objects;
		this.speed= newSpeed;
		
				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
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
	public WetTurtle(int xpos, int ypos, int s) {
		turtle1 = new Image(oBject.getUrlAnimation1(), oBject.getWidth(), oBject.getHeight(), true, true);
		turtle2 = new Image(oBject.getUrlAnimation2(), oBject.getWidth(), oBject.getHeight(), true, true);
		turtle3 = new Image(oBject.getUrlAnimation3(),oBject.getWidth(), oBject.getHeight(), true, true);
		turtle4 = new Image(oBject.getUrlAnimation4(),oBject.getWidth(), oBject.getHeight(), true, true);
		setX(xpos);
		setY(ypos);
		this.speed = s;
		setImage(turtle2);
	}
	public boolean isSunk() {
		return sunk;
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
