package Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

import Deleted_Discarded.InfoLabel;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Digit;
import model.actorRefactored.IntersectingActors;
import model.actorRefactored.MovableActors;
import model.actors.Frogger;
import view.GameSetter;
import view.ScoreHandler;
import view.World;

/**
 * This class is called the GameViewManager and it is responsible for rendering the view of the program.
 * It makes a World Object, a Game Setter Object and then makes these two work together in a timer. 
 * @author HP
 * 
 *
 */
public class GameViewManager{
	
	private ImageView pauseButton;
	private World background;
	private Scene gameScene;
	private Stage gameStage;
	AnimationTimer timer;
	private MediaPlayer mediaPlayer;
	private Frogger frogger;
	private ArrayList<IntersectingActors> objects;
	private String newHighScore; //used if the user sets a new High Score 
	private int numOfLevel;

	
	private boolean speedChange;
	ImageView speedImageView;
	Label speedLabel;
	TextInputDialog textDialog;
	ScoreHandler scoreHandler= new ScoreHandler();
	
	private static final int GAME_WIDTH= 600;
	private static final int GAME_HEIGHT=800;
	private static final String BACKGROUND_IMAGE="file:src/view/ViewResources/FrogBackground.png";
	private static final String MUSIC_URL= "src/view/ViewResources/Frogger Main Song Theme (loop).mp3";
	private static final String SPEED_IMAGE_URL= "file:src/view/ViewResources/speedincrease.png";
	private static final String HIGH_SCORE_FILE="src/view/highscore.txt";
	private static final String PAUSE_BUTTON= "file:src/view/ViewResources/pause-button.png";
	
	private Stage menuStage;
	private String playerName;
	
	public GameViewManager() {
		initializeStage();
		createBackground();
	}
	
	/**
	 * The initializeStage() method is able used to set up the Scene and the stage for the constructor.
	 */

	private void initializeStage() {
		background= new World();
		gameScene = new Scene(background, GAME_WIDTH, GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		gameStage.setResizable(false);
	}
	
	/**
	 * The createBackground method sets the background Image in the world object.
	 */
	
	private void createBackground() {
		ImageView backgroundImage= new ImageView();
		backgroundImage.setImage( new Image(BACKGROUND_IMAGE,600,800,true,false));
		background.add(backgroundImage);
		}
	
	/**
	 * This method is set to public and will be accessed by a class that makes a GameViewManager object. 
	 * This method is used in order to hide passed in screen and show the present one.
	 * @param menuStage is used to hide the Stage specified here
	 * @param choosenLevel is an instance of enum and is used as an argument to the method createGameAccording to level
	 */
	
	public void createNewGame(Stage menuStage, String choosenLevel) {
		this.menuStage=menuStage;
		this.menuStage.hide();
		scoreHandler.readHighScores(HIGH_SCORE_FILE);
		createGameAccordingToLevel(choosenLevel);
		gameStage.show();
	}
	
	/**
	 * Calls startGame method according to level chosen by the user.
	 * @param choosenLevel specifies which level has been chosen by the user
	 */
	
	private void createGameAccordingToLevel(String choosenLevel) {
		switch (choosenLevel) {
		case "LAZY":
			numOfLevel=0;
			startGame(3,3,3,10,3,3,3,0,false);
			break;
		case "AVERAGE":
			numOfLevel=1;
			startGame(6,6,6,6,6,6,6,6,false);
			break;
		case "CRAZY":
			numOfLevel=2;
			startGame(9,9,9,9,9,9,9,9,true);
			break;
		default: System.out.println("something seriously is wrong here");
			break;
		}
		
	}
/**
 * Method is used to create Game according to whatever the chosen level is. This method creates Gamesetter object according all the arguments that it receives.
 * @param numOfLogs number of logs that should be present in the game
 * @param numOfSlowCars number of slow cars that should be in the game 
 * @param numOfFastCars number of fast cars that should be in the game
 * @param numOfLargeTrucks number of Large trucks that should be in the game
 * @param numOfSmallTrucks number of small trucks in the game
 * @param numOfTurtles number of Turtles that should be in the game
 * @param numOfWetTurtles number of WetTurtles that should be present in the game
 * @param numOfCrocodiles number of Crocodiles in the game
 * @param CrocHead specifies whether there is going to be a CrocHead in the game or not
 */
	
	private void startGame(int numOfLogs, int numOfSlowCars,int numOfFastCars,int numOfLargeTrucks,
			int numOfSmallTrucks, int numOfTurtles,int numOfWetTurtles, int numOfCrocodiles, boolean CrocHead) {
			
			GameSetter game = new GameSetter(numOfLogs,numOfSlowCars,numOfFastCars,numOfLargeTrucks,
					numOfSmallTrucks,numOfTurtles,numOfWetTurtles,numOfCrocodiles,CrocHead);
			frogger=(Frogger) game.getFrogger();
			objects= game.getArrayList();
			setObjectsToBackground();
			createLabels();
			DisplayHighScore(scoreHandler.getHighScoreForLevel(numOfLevel));
			makeSpeedChange();
			createTimer();
			createPauseButton();
			timer.start();
			createNameDialog();
			
			playMusic();
	}
	
	/**
	 * Method creates a Pause ImageView which if clicked gives the user the option to quit the game.
	 */
	private void createPauseButton() {
		
		pauseButton= new ImageView(new Image(PAUSE_BUTTON, 60, 60, true, true));
		background.add(pauseButton);
		pauseButton.setX(520);
		pauseButton.setY(10);
		//pauseButton.setFocusTraversable(true);
		pauseButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				timer.stop();
				mediaPlayer.stop();
				ButtonType yes = new ButtonType("Yes", ButtonData.OK_DONE);
				ButtonType no = new ButtonType("No", ButtonData.CANCEL_CLOSE);
				Alert alert = new Alert(AlertType.WARNING,"Want to go on?",yes,no);
				alert.getDialogPane().setMaxWidth(110);
				alert.setTitle("Pause");
				alert.setGraphic(null);
				alert.setHeaderText(null);
				Optional<ButtonType> result = alert.showAndWait();

				if (result.orElse(no) == yes) {
				timer.start();
				playMusic();
				} else {
				endGame();
				}
			}
		});
	}


	/**
	 * This method creates and Displays a TextInputDialog for the user to enter their name.
	 */
	private void createNameDialog() {
		textDialog= new TextInputDialog();
		
		textDialog.setTitle("Enter your name Good Sir");
		textDialog.setGraphic(null);
		textDialog.setHeaderText(null);
		textDialog.getDialogPane().setContentText("Name");
		
		@SuppressWarnings("unused")
		Optional<String> result =textDialog.showAndWait();
		
		TextField input = textDialog.getEditor();
		
		if(input.getText() !=null && input.getText().toString().length() != 0) {
			playerName=input.getText().toString();
		}
		else {
			playerName="Nobody";
			System.out.println("User did not enter anything");
		}
		
	}

	/**
	 * This method is used to set Objects received from the Gamesetter object in an ArrayList to the world Object.
	 */
	private void setObjectsToBackground() {
		for(int i=0; i<objects.size();i++) {
			background.add(objects.get(i));
		}
	}
	/**
	 * Is used to create the Animation Timer. 
	 * In the timer's handle method it is checked whether the game is over i.e. the user has died thrice.
	 * The handle method also checks whether there is a change of score, if there is score is updated accordingly.
	 * Handle method also checks if stage is ended, if it is it calls showSpeedChange method, it also increases the speed for the next stage of the level.
	 */
		
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	gameStage.setOnCloseRequest(evt -> endGame());
            	int speedMultiplier=1;
            	double speed=1;
            	if(frogger.isGameOver()) {
            		
            		System.out.print("STOPP:");
            		stop();
            		if(scoreHandler.isNewHighScore(frogger.getPoints(), numOfLevel,scoreHandler.getHighScoresList())) {
            			newHighScore=playerName+ ":"+ frogger.getPoints();
            			scoreHandler.replaceLine(newHighScore,numOfLevel,HIGH_SCORE_FILE);
            			createAlertBox("Great, you made a new High Score", "LET'S SEE YOU DO THAT AGAIN");
            		}
            		else {
            		createAlertBox("You're Done Bro Let's Go Back","BETTER LUCK NEXT TIME LOSER");
            		}
            	}
            	ArrayList<MovableActors> actors = (ArrayList<MovableActors>) background.getObjects(MovableActors.class);
                for (MovableActors anActor: actors) {
                	speed=anActor.getSpeed();
                	anActor.act(now,actors,speed);
                }
                frogger.act(now);
            	if (frogger.changeScore()) {
            		setNumber(frogger.getPoints());
            	}           	
            	if(frogger.hasStageEnded()) {
            		System.out.println("stage has ended bro");
            		speedMultiplier+=1;
            		System.out.printf("The speed has increased by %d", speedMultiplier);
            		speedChange=true;
            		if(hasSpeedChanged()) {
            			System.out.println("why is speed change not showing then...");
            			showSpeedChange();
            		}
            		for (MovableActors anActor: actors) {
                     	speed=anActor.getSpeed()*speedMultiplier;
                     	anActor.act(now, actors,speed);
                     }
            		if(speedMultiplier== 3) {
            			createAlertBox("You finished this Level", "FIND SOMETHING BETTER TO DO");
            			stop();
            		}
            	}
            }

			
        };
    }
	
	/**
	 * This method creates an AlertBox which is displayed after the Game ends. It calls for the endGame method.
	 */
	private void createAlertBox(String title, String contentText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.getDialogPane().setMaxWidth(400);
		alert.setGraphic(null);
		alert.setHeaderText(null);
		alert.setOnHidden(evt -> endGame());
		alert.setContentText(contentText);
		alert.show();
	
	}
	/**
	 * This method closes the gameStage and shows the menuStage again.
	 */
	private void endGame() {
		mediaPlayer.stop();
		//menuStage.show();
		gameStage.close();
		
	}

	/**
	 * Method checks boolean variable speed change.
	 * @return if speedChange is true return true else return false
	 */
	 public boolean hasSpeedChanged() {
	    	if(speedChange) {
	    		speedChange=false;
	    		return true;
	    	}
	    	else 
	    		return false;
	    }
	 /**
	  * Makes speedChange label, adds it to the World Object and also sets its visibility to false initially.
	  */
	
	private void makeSpeedChange() {
		speedImageView =new ImageView(new Image(SPEED_IMAGE_URL, 580,121,true,true));
		speedLabel =new Label("",speedImageView);
		speedLabel.setLayoutX(12);
		speedLabel.setLayoutY(350);
		background.add(speedLabel);
		speedLabel.setVisible(false);
	}
	/**
	 * Stops the timer, has a transition that flashes the speedChange label on screen.
	 * After transition finishes it starts the timer again from the point it left off and sets visibility of the speedLabel to false.
	 */
	
	private void showSpeedChange() {
		timer.stop();
		speedLabel.setVisible(true);
		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), speedLabel);
		
		fadeTransition.setFromValue(1); 
		fadeTransition.setToValue(0.0);
		 
		fadeTransition.play();
		fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				speedLabel.setVisible(false);
				timer.start();
			}
		});		
	}
	
	/**
	 * Plays background Music by using MediaPlayer and Media Objects.
	 */

	public void playMusic() {
			String musicFile = MUSIC_URL;   
			Media sound = new Media(new File(musicFile).toURI().toString());
			mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		    mediaPlayer.play();
		}


	/**
	 * Method shows points and any change in points on the GUI according to argument received.
	 * @param n is the score of the player at the current moment in time.
	 */
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 570 - shift, 760));
    		  shift+=30;
    		}
    }
	/**
	 * Displays the digits of the HighScore received on the screen.
	 * Displays four zeroes if the HighScore received is zero otherwise displays the number.
	 * @param highScore is the HighScore received for the particular level chosen by the user
	 */
    private void DisplayHighScore(int highScore) {
    	System.out.println("This is the value of n"+highScore);
    	int shift = 0;	
    	if(highScore==0) {
    		for(int i=0;i<4;i++) {
    			background.add(new Digit(0,30,300-shift,760));
    			shift+=30;
    		}
    		shift=0;
    	}
    	else {
    	while (highScore > 0) {
    		  int d = highScore / 10;
    		  int k = highScore- d * 10;
    		  highScore = d;
    		  background.add(new Digit(k, 30, 300 - shift, 760));
    		  shift+=30;
    		}
    	}
    }
	
    /**
     * Method creates HighScore and Points Labels that are displayed on the screen
     */
	private void createLabels() {
	InfoLabel highScore = new InfoLabel("HIGH SCORE:", false);
	highScore.setLayoutX(40);
	highScore.setLayoutY(760);
	highScore.setTextFill(Color.web("#f55353",0.8));
	background.add(highScore);
	
	InfoLabel points = new InfoLabel("POINTS", false);
	points.setLayoutX(370);
	points.setLayoutY(760);
	points.setTextFill(Color.web("#f55353",0.8));
	background.add(points);
	}
	
	
	
    
}

	