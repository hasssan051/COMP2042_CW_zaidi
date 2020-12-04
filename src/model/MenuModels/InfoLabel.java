package model.MenuModels;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

public class InfoLabel extends Label{

	public final static String FONT_PATH= "src/model/MenuResources/kenvector_future.ttf";
	public final static String FONT_PATH_2= "src/view/ViewResources/HighscoreHero.ttf";
	
	public final static String BACKGROUND_IMAGE_STRING= "/view/ViewResources/green_button13.png";
	
	private boolean isMainLabel;
	
	public InfoLabel(String text) {
		
		setPrefWidth(380);
		setPrefHeight(49);
		//setPadding(new Insets(40,40,40,40));
		setText(text);
		setWrapText(true);
		setLabelFont(FONT_PATH);
		setAlignment(Pos.CENTER);
			
		/*
		 * BackgroundImage backgroundImage = new BackgroundImage(new
		 * Image(BACKGROUND_IMAGE_STRING, 380, 49, false, true),
		 * BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
		 * BackgroundPosition.DEFAULT,null); setBackground(new
		 * Background(backgroundImage));
		 */
	}
	
	public InfoLabel(String text, boolean isMainLabel) {
		/*
		 * setPrefWidth(200); setPrefHeight(30);
		 */
		
			setText(text);
		//setWrapText(true);
			setLabelFont(FONT_PATH);
		
		
	}
	
	
	
	
	//method to set the font of the label
	private void setLabelFont(String fontPath) {
		try {
			setFont(Font.loadFont(new FileInputStream(new File(fontPath)), 23));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Verdana",23));
			
		}
	}
	
	
	
	
}
