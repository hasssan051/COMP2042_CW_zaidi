package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Class used in order to create and show a Digit as an ImageView on the screen.
 * @author HP
 *
 */
public class Digit extends ImageView{
	int dim;
	Image im1;
	
	/**
	 * Constructor used to initialize the object
	 * @param n The number between 0 and 9 that needs to be displayed on the screen.
	 * @param dim positioning of the numbers in relation to one another.
	 * @param x position of the ImageView on the x axis
	 * @param y position of the ImageView on the y axis
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/model/ActorResources/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}

}
