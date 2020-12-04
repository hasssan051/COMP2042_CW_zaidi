package model;

import javafx.scene.image.Image;

public class WetTurtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	
	private int speed=0;
	boolean sunk = false;
	
	private static final String TURTLEANIMATION1_URL ="file:src/model/ActorResources/TurtleAnimation1.png";
	private static final String TURTLEANIMATION2WET_URL ="file:src/model/ActorResources/TurtleAnimation2Wet.png";
	private static final String TURTLEANIMATION3WET_URL ="file:src/model/ActorResources/TurtleAnimation3Wet.png";
	private static final String TURTLEANIMATION4WET_URL ="file:src/model/ActorResources/TurtleAnimation4Wet.png";
	
	
	@Override
	public void act(long now) {

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
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image(TURTLEANIMATION1_URL, w, h, true, true);
		turtle2 = new Image(TURTLEANIMATION2WET_URL, w, h, true, true);
		turtle3 = new Image(TURTLEANIMATION3WET_URL, w, h, true, true);
		turtle4 = new Image(TURTLEANIMATION4WET_URL, w, h, true, true);
		setX(xpos);
		setY(ypos);
		this.speed = s;
		setImage(turtle2);
	}
	public boolean isSunk() {
		return sunk;
	}
}
