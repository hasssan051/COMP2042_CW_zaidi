//package Deleted_Discarded;
//
//import javafx.scene.image.Image;
//import model.Actor;
//
//public class Crocodile extends Actor {
//	
//	
//	private double speed=0;
//	@Override
//	public void act(long now) {
//		move(speed , 0);
//		if (getX() > 600 && speed>0)
//			setX(-200);
//		if (getX() < -50 && speed<0)
//			setX(600);
//	}
//	
//	public Crocodile(String imageLink, int xpos, int ypos, int s, int w, int h) {
//		setImage(new Image(imageLink, w,h, true, true));
//		setX(xpos);
//		setY(ypos);
//		this.speed = s;	
//	}
//	
//	
//	public boolean getLeft() {
//		return speed < 0;
//	}
//		
//	}
//
//
