package Deleted_Discarded;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//this class only extends actor since it using the setImage method. The setIMage method is from Imageview which actor extends
public class BackgroundImage extends ImageView{

	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
		
	}

}
