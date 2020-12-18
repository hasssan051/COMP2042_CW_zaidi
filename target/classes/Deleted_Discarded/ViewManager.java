package Deleted_Discarded;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.ScoreHandler;

public class ViewManager {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	private static final String HIGH_SCORE_FILE="src/view/highscore.txt";
	public final static String FONT_PATH= "src/model/MenuResources/kenvector_future.ttf";
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
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
		mainStage=new Stage();
		mainStage.setScene(mainScene);
		mainStage.setResizable(false);
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
		
		
		createLevelChooserSubScene();
		createHelpSubScene();
		createScoreSubScene();
		
	}
	
	private void createScoreSubScene() {
		subSceneScore = new FroggerSubScene();
		mainPane.getChildren().add(subSceneScore);
		
		InfoLabel heading =new InfoLabel("SCORE TABLE", true);
		heading.setLayoutX(160);
		heading.setLayoutY(27);
		subSceneScore.getPane().getChildren().add(heading);
		
		VBox column = new VBox();
		column.setLayoutX(40);
		column.setLayoutY(100);
		
		ArrayList<HBox> hboxList= new ArrayList<HBox>();

		column.setSpacing(50);
		
		ArrayList<InfoLabel> levelLabelList = new ArrayList<InfoLabel>();
		for(LEVEL level: LEVEL.values()) {	
			InfoLabel levelLabel;
			if(level.getLevel().equals("LAZY")) {
				levelLabel = new InfoLabel(level.getLevel()+"\t\t:");
			} else {
			levelLabel = new InfoLabel(level.getLevel()+"\t:");}
			levelLabel.setPrefSize(150, 20);
			levelLabel.setTextFill(Color.web("#6e0412",0.8));
			levelLabelList.add(levelLabel);
			hboxList.add(new HBox());
		}	
		for(HBox hbox: hboxList) {
			hbox.setSpacing(50);
			hbox.setLayoutX(370 -(118*2));
			hbox.setLayoutY(100);
			hbox.setAlignment(Pos.CENTER_LEFT);
		}
		
		
		ScoreHandler scoreHandler =new ScoreHandler();
		
		scoreHandler.readHighScores(HIGH_SCORE_FILE);
		ArrayList<String> highScoreList =scoreHandler.getHighScoresList();
		for(int i=0;i<highScoreList.size();i++) {
			InfoLabel name= new InfoLabel((highScoreList.get(i)).split(":")[0]);
			name.setPrefSize(100, 20);
			InfoLabel score = new InfoLabel((highScoreList.get(i)).split(":")[1]);
			score.setPrefSize(70, 20);
			hboxList.get(i).getChildren().add(levelLabelList.get(i));
			hboxList.get(i).getChildren().add(name);
			hboxList.get(i).getChildren().add(score);
			
		}
		
	
		for(int i=0;i<highScoreList.size();i++) {
			column.getChildren().add(hboxList.get(i));
		}
		
		subSceneScore.getPane().getChildren().add(column);
	
	}

	private void createHelpSubScene() {
		subSceneHelp = new FroggerSubScene();
		mainPane.getChildren().add(subSceneHelp);
		
		InfoLabel heading =new InfoLabel("HELP", true);
		heading.setLayoutX(225);
		heading.setLayoutY(27);
		subSceneHelp.getPane().getChildren().add(heading);
		
		GridPane gridPane = new GridPane();
		gridPane.setVgap(5); 
	    gridPane.setHgap(5);       
	      
	    gridPane.setAlignment(Pos.CENTER); 
	    
		InfoLabel helpLabel= new InfoLabel("The game is played using the keys W A S D to move Frogger"
				+ "/nSo we have a total of three Levels LAZY AVERAGE CRAZY"
				+ "/nThe names suggest how hard the levels are"
				+ "/nIn each of the Level, we have a speed increase");
		helpLabel.setPrefSize(150, 20);
		helpLabel.setTextFill(Color.web("#6e0412",0.8));
		gridPane.add(helpLabel,2,0);
		
		
		subSceneHelp.getPane().getChildren().add(gridPane);
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
					//the chosen level will be set to chosen 
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
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				if(choosenLevel != null) {
					
					GameViewManager gameManager= new GameViewManager();
					//gameManager.createNewGame(mainStage, choosenLevel);
				}
			}
		});
		
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
		Image backgroundImage= new Image("view/ViewResources/background.jpg",800,600,true,false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,null);
		mainPane.setBackground(new Background(background));
	}
	
	private void createLogo() {
		ImageView logo= new ImageView("view/ViewResources/frogger-logo-2.png");
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
		ImageView icon = new ImageView("view/ViewResources/frog.png");
		
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
