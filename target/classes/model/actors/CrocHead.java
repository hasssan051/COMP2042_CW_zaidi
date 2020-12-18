package model.actors;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;
import model.ActorResources.ActorComponents;
import model.actorRefactored.MovableActors;

/**
 * This class makes the Crocodile Head that goes from left to right,trying to eat frogger.
 * @author HP
 *
 */

public class CrocHead extends MovableActors{
	
	ActorComponents oBject;
	private double speed;
	KeyFrame firstFrame ;
	KeyFrame thirdFrame ;
	
	Timeline timeLine = new Timeline();
	
	
	@Override
	public void act(long now,ArrayList<MovableActors> objects,double newSpeed) {
		this.speed= newSpeed;
		moveCrocHead();	
	}
	
	public CrocHead(ActorComponents object,int size, int xpos, int ypos, double s) {
		this.oBject= object;
		setImage(new Image(oBject.getObject(), size,size, true, true));
		setX(xpos);
		setY(ypos);
		this.speed = s;	
		//addElementsToList();
	}
	/**
	 * This method creates the TimeLine that makes the CrocHead move from left to right.
	 */
	private void moveCrocHead() {
		firstFrame =new KeyFrame(Duration.seconds(speed), new KeyValue(this.xProperty(),550));
		thirdFrame = new KeyFrame(Duration.seconds(speed+1), new KeyValue(this.xProperty(),-550));

		timeLine.getKeyFrames().addAll(firstFrame,thirdFrame);
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.play();
	}

	@Override
	public double getSpeed() {
		return this.speed;
	}


	
	

}
