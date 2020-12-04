package model;

import javafx.scene.image.Image;

public class End extends Actor{
	boolean activated = false;
	private int counter=0;
	
	private static final String END_URL="file:src/model/ActorResources/End.png";
	private static final String SET_END_URL="file:src/model/ActorResources/FrogEnd.png";
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image(END_URL, 60, 60, true, true));
	}
	
	public void setEnd() {
		setImage(new Image(SET_END_URL, 70, 70, true, true));
		activated = true;
		counter++;
	}
	public void unsetEnd() {
		setImage(new Image(END_URL, 60, 60, true, true));
		activated=false;
	}
	
	public boolean isActivated() {
		return activated;
	}

	@Override
	public void act(long now) {
		/*
		 * if(counter==5) { this.activated=false; }
		 */
	}
	

}
