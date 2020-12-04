package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Digit extends ImageView{
	int dim;
	Image im1;
	
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/model/ActorResources/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}


	
	
}
