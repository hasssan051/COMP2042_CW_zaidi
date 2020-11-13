package view;

import java.util.ArrayList;
import java.util.List;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.FroggerButton;
import model.FroggerSubScene;
import model.InfoLabel;
import model.LEVEL;
import model.LevelPicker;
import javafx.scene.effect.DropShadow;

public class ViewManager {
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 800;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	private final static int MENU_BUTTON_START_X=40;
	private final static int MENU_BUTTON_START_Y=220;
	
	private FroggerSubScene subSceneScore;
	private FroggerSubScene subSceneHelp;
	private FroggerSubScene subSceneLevelChooser;
	
	private FroggerSubScene sceneToHide; //field is used to store the scene that needs to be hidden
	
	List<FroggerButton> menuButtons; //a list to contain all the menu buttons at the start
	
	List<LevelPicker> levelList; //list that will store the levels inside it 
	private LEVEL choosenLevel; 
	
	public ViewManager() {
		menuButtons= new ArrayList<>();
		mainPane= new AnchorPane();
		mainScene = new Scene(mainPane,HEIGHT,WIDTH);
		mainStage=new Stage();
		mainStage.setScene(mainScene);
		createButton();
		createBackground();
		createSubScene();
		
		
	}
	
	//if there is a subscene that needs to be hidden move it 
	private void showSubScene(FroggerSubScene subScene) {
		if(sceneToHide != null) {
			sceneToHide.moveSubScene();
		}
		//we show the new subscene and store it in the scenetohide variable
		subScene.moveSubScene();
		sceneToHide=subScene;
	}
	
	private void createSubScene() {
		subSceneScore = new FroggerSubScene();
		mainPane.getChildren().add(subSceneScore);
		
		subSceneHelp = new FroggerSubScene();
		mainPane.getChildren().add(subSceneHelp);
		
		createLevelChooserSubScene();
		
	}
	
	//method used to create levelchoosersubscene 
	private void createLevelChooserSubScene() {
		subSceneLevelChooser= new FroggerSubScene();
		mainPane.getChildren().add(subSceneLevelChooser);
		
		InfoLabel chooseLevelLabel = new InfoLabel("CHOOSE LEVEL");
		chooseLevelLabel.setLayoutX(70);
		chooseLevelLabel.setLayoutY(25);
		
		
		
		subSceneLevelChooser.getPane().getChildren().add(chooseLevelLabel);
		
		subSceneLevelChooser.getPane().getChildren().add(createLevelsToChoose()); //adds the hbox to the subscene 
		
		subSceneLevelChooser.getPane().getChildren().add(createStartButton()); // adds start button to the subscene 
		
		
	}
	
	//method below makes the images for the levels
	private HBox createLevelsToChoose() {
		HBox box = new HBox();
		box.setSpacing(20);
		levelList = new ArrayList<LevelPicker>();
		//below is how we get instances from an enum using the values method
		for(LEVEL level: LEVEL.values()) {
			LevelPicker levelToPick= new LevelPicker(level);			
			levelList.add(levelToPick);
			box.getChildren().add(levelToPick);
			levelToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					for(LevelPicker level: levelList) {
						level.setIsCircleChoosen(false); //if we click on one of the levels the rest would be set to false
					}
					levelToPick.setIsCircleChoosen(true);//the chosen level will be set to chosen 
					choosenLevel=levelToPick.getLevel();
				}
			});
		}
		box.setLayoutX(310 -(118*2));
		box.setLayoutY(100);
		return box;
	}
	
	private FroggerButton createStartButton() {
		FroggerButton startButton =new FroggerButton("START");
		startButton.setLayoutX(270);
		startButton.setLayoutY(285);
		return startButton;
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	private void addMenuButton(FroggerButton button) {
		button.setLayoutX(MENU_BUTTON_START_X);
		button.setLayoutY(MENU_BUTTON_START_Y+ menuButtons.size() *100);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
	}
	
	private void createButton() {
		createScoreButton();
		createPlayButton();
		createHelpButton();
		createExitButton();
		createLogo();
		createIcon();
	}
	
	private void createPlayButton() {
		FroggerButton playButton = new FroggerButton("PLAY");
		addMenuButton(playButton);
		
		playButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(subSceneLevelChooser);
				
			}
		});
		
	}
	
	private void createScoreButton() {
		FroggerButton scoreButton = new FroggerButton("SCORE");
		addMenuButton(scoreButton);
		
		scoreButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(subSceneScore);
				
			}
		});
	}
	
	private void createHelpButton() {
		FroggerButton helpButton = new FroggerButton("HELP");
		addMenuButton(helpButton);
		
		helpButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				showSubScene(subSceneHelp);
				
			}
		});
	}
	
	private void createExitButton() {
		FroggerButton exitButton = new FroggerButton("EXIT");
		addMenuButton(exitButton);
		
		//implementing exit logic
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				mainStage.close();
				
			}
		});
	}


	private void createBackground() {
		Image backgroundImage= new Image("view/resources/background.jpg",800,600,true,false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,null);
		mainPane.setBackground(new Background(background));
		
	}
	
	private void createLogo() {
		ImageView logo= new ImageView("view/resources/frogger-logo-2.png");
		logo.setFitHeight(350);
		logo.setFitWidth(450);
		logo.setPreserveRatio(true);
		logo.setLayoutX(290);
		logo.setLayoutY(50);
		
		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(new DropShadow(4.0, Color.ALICEBLUE));
										
			}
		});
		
		logo.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(null);
				
			}
		});
		
		mainPane.getChildren().add(logo);
	}
	
	private void createIcon() {
		ImageView icon = new ImageView("view/resources/frog.png");
		
		icon.setFitHeight(200);
		icon.setFitWidth(200);
		icon.setPreserveRatio(true);
		icon.setLayoutX(40);
		icon.setLayoutY(20);
		
		icon.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				icon.setEffect(new DropShadow(4.0, Color.ALICEBLUE));
										
			}
		});
		
		icon.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				icon.setEffect(null);
				
			}
		});
		mainPane.getChildren().add(icon);
	}
	
	
	
	
	
	
	
	
	
}
