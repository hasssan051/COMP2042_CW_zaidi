package model;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.Image;
import model.ActorResources.ActorComponents;

public class CrocHead extends MovableActors{
	//Random random = new Random();
	
	ArrayList<Integer> xPosition =new ArrayList<>();
	ActorComponents oBject;
	
	private double speed;
	@Override
	public void act(long now,ArrayList<MovableActors> objects,double newSpeed) {
		this.speed= newSpeed;
		this.setVisible(false);
		move(0,speed);
		this.setVisible(true);
		if(getY()>65*2) {
			setY(65);
			setX(getRandomElement());
			this.setVisible(false);
			
		 }
		
	}
	
	public CrocHead(ActorComponents object,int size, int xpos, int ypos, double s) {
		this.oBject= object;
		setImage(new Image(oBject.getObject(), size,size, true, true));
		setX(xpos);
		setY(ypos);
		this.speed = s;	
		addElementsToList();
	}
	
	private int getRandomElement() 
    { 
        Random rand = new Random(); 
        return xPosition.get(rand.nextInt(xPosition.size())); 
    } 
	
	private void addElementsToList() {
		 int xpos=12;
		for(int i=0; i<5;i++) {
			xPosition.add(xpos);
			xpos+=128;
		}
	}

	@Override
	public double getSpeed() {
		return this.speed;
	}


	
	

}
