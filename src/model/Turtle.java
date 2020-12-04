package model;

import javafx.scene.image.Image;

public class Turtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	
	private static final String TURTLEANIMATION_1="file:src/model/ActorResources/TurtleAnimation1.png";
	private static final String TURTLEANIMATION_2="file:src/model/ActorResources/TurtleAnimation2.png";
	private static final String TURTLEANIMATION_3="file:src/model/ActorResources/TurtleAnimation3.png";
	
	private int speed=0;
	boolean bool = true;
	@Override
	public void act(long now) {

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
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image(TURTLEANIMATION_1, w, h, true, true);
		turtle2 = new Image(TURTLEANIMATION_2, w, h, true, true);
		turtle3 = new Image(TURTLEANIMATION_3, w, h, true, true);
		setX(xpos);
		setY(ypos);
		this.speed = s;
		setImage(turtle2);
	}
}
