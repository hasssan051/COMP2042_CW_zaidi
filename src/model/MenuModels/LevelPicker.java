package model.MenuModels;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


//in this class we're creating a Vbox that contains the images 
public class LevelPicker extends VBox{
	
	private ImageView frogLevelImage;
	private ImageView circleImage;
	
	//strings to store the path to images that will be presented on the subscene 
	private String circleNotChoosen= "view/ViewResources/levelchooser/grey_circle.png";
	private String circleChoosen ="view/ViewResources/levelchooser/blue_boxTick.png";
	
	private LEVEL level; //this is an instance of the enum 
	
	private boolean isCircleChoosen; //boolean that says whether or not a level is choosen
	
	public LevelPicker(LEVEL level) {
		circleImage = new ImageView(circleNotChoosen);
		frogLevelImage= new ImageView(level.getUrl());
		this.level= level;
		isCircleChoosen= false; //at the start the button is not choosen 
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		
		this.getChildren().add(frogLevelImage); //adding images to the vbox
		this.getChildren().add(circleImage);
		
		this.getChildren().add(setNormalInfoLabel(level.toString(), false));
	}
	
	
	private InfoLabel setNormalInfoLabel(String labelName, boolean isMainLabel) {
		InfoLabel label = new InfoLabel(labelName, isMainLabel);
		return label;
	}

	public LEVEL getLevel() {
		return level;
	}
	
	public boolean getIsCircleChoosen() {
		return isCircleChoosen;
	}
	
	public void setIsCircleChoosen(boolean isCircleChoosen) {
		this.isCircleChoosen =isCircleChoosen;
		String imageToSet= this.isCircleChoosen ? circleChoosen :circleNotChoosen;
		circleImage.setImage(new Image(imageToSet));
	}
	
	
	
	
	
	
	
}
