package Controller;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.ScoreHandler;

/**
 * This class is used to control the Menu.fxml file. It is the Controller class for the FXML view.
 * @author HP
 *
 */
public class Controller {
	
		private static final String HIGH_SCORE_FILE="src/view/highscore.txt";
		private static final String CIRCLE_CHOSEN_IMAGE="/view/ViewResources/levelchooser/blue_boxTick.png";
		private static final String CIRCLE_NOTCHOSEN_IMAGE="/view/ViewResources/levelchooser/grey_circle.png" ;
		
		
		
		private Pane paneToHide;
		private ImageView choosenLevel;
		HashMap<Pane, Boolean> paneHiddenMap= new HashMap<Pane, Boolean>();
		HashMap<ImageView,Boolean> circlesChoosenMap = new HashMap<ImageView, Boolean>();
		/**
		 * 
		 */
		/**
		 * This method initializes all the HashMaps in the class and sets the initial values for each circle in the view.
		 */
		@FXML
		private void initialize() {
			
			paneHiddenMap.put(scorePane,true);
			paneHiddenMap.put(levelChooserPane,true);
			paneHiddenMap.put(helpPane,true);	
			
			circlesChoosenMap.put(circle1,false);
			circlesChoosenMap.put(circle2,false);
			circlesChoosenMap.put(circle3,false);
			
			circle1.setImage(new Image(CIRCLE_NOTCHOSEN_IMAGE));
			circle2.setImage(new Image(CIRCLE_NOTCHOSEN_IMAGE));
			circle3.setImage(new Image(CIRCLE_NOTCHOSEN_IMAGE));
		}
	
	  	 @FXML 
	  	 private Pane levelChooserPane;
	     
	     @FXML
	     private Pane scorePane;
	     @FXML
	     private Label crazyNameLabel;

	     @FXML
	     private Label crazyScoreLabel;

	     @FXML
	     private Label averageNameLabel;

	     @FXML
	     private Label averageScoreLabel;

	     @FXML
	     private Label lazyNameLabel;

	     @FXML
	     private Label lazyScoreLabel;
	     
	     @FXML
	     private Pane helpPane;
	     
	     @FXML
	     private ImageView circle1;

	     @FXML
	     private ImageView circle2;

	     @FXML
	     private ImageView circle3;
		

	     @FXML
	     void circle1Clicked(MouseEvent event) {
	    	 circlesChoosenMap.replace(circle1, true);
	    	 circlesChoosenMap.replace(circle2, false);
	    	 circlesChoosenMap.replace(circle3, false);
	    	 setCircleChoosen();
	    	 choosenLevel=circle1;
	    	
	     }

	     @FXML
	     void circle2Clicked(MouseEvent event) {
	    	 circlesChoosenMap.replace(circle2, true);
	    	 circlesChoosenMap.replace(circle1, false);
	    	 circlesChoosenMap.replace(circle3, false);
	    	 setCircleChoosen();
	    	 choosenLevel=circle2;
	    	 
	     }

	     @FXML
	     void circle3Clicked(MouseEvent event) {
	    	 circlesChoosenMap.replace(circle3, true);
	    	 circlesChoosenMap.replace(circle1, false);
	    	 circlesChoosenMap.replace(circle2, false);
	    	 setCircleChoosen();
	    	 choosenLevel=circle3;
	    	 
	     }
	     
	  	@FXML
	  	void exitButtonPressed(ActionEvent event) {
	  		Platform.exit();
	  	}

	    @FXML
	    void helpButtonPressed(ActionEvent event) {
	    	showPane(helpPane);
	    }

	    @FXML
	    void playButtonPressed(ActionEvent event) {
	    	showPane(levelChooserPane);	    	
	    }

	    @FXML
	    void scoreButtonPressed(ActionEvent event) {
	    	showPane(scorePane);

			ScoreHandler scoreHandler =new ScoreHandler();
			scoreHandler.readHighScores(HIGH_SCORE_FILE);
			
			ArrayList<String> highScoreList =scoreHandler.getHighScoresList();
			ArrayList<Label> nameLabelList= new ArrayList<>();
			nameLabelList.add(0, crazyNameLabel);
			nameLabelList.add(1,averageNameLabel);
			nameLabelList.add(2, lazyNameLabel);
			
			ArrayList<Label> scoreLabelList= new ArrayList<>();
			scoreLabelList.add(0, crazyScoreLabel);
			scoreLabelList.add(1,averageScoreLabel);
			scoreLabelList.add(2, lazyScoreLabel);
			
			for(int i=0;i<highScoreList.size();i++) {
				nameLabelList.get(i).setText((highScoreList.get(i)).split(":")[0]);
				scoreLabelList.get(i).setText((highScoreList.get(i)).split(":")[1]);
			}
			
	    }
	    
	    @FXML
	    void startButtonPressed(ActionEvent event) {
	    	GameViewManager gameManager= new GameViewManager();
	    	Stage menuStage = new Stage();
	    	if(choosenLevel != null) {
	    		if(choosenLevel==circle1) {
	    			gameManager.createNewGame(menuStage,"LAZY");
	    		}
	    		else if(choosenLevel==circle2) {
	    			gameManager.createNewGame(menuStage,"AVERAGE");
	    		}
	    		else {
	    			gameManager.createNewGame(menuStage,"CRAZY");
	    		}
	    	}
	    	
	    	//menuStage.setScene(gameManager.getGameScene());

	    }
	    /**
	     * This method is used to hide one scene and show the one the user wants by calling moveSubScene method.
	     * @param showPane pane that is to be shown.
	     */
	    private void showPane(Pane showPane) {
			if(paneToHide != null) {
				movePane(paneToHide);
			}
			movePane(showPane);
			paneToHide=showPane;
		}
	    /**
	     * This method uses TranslateTransition class to move a Pane.
	     * @param pane
	     */
		private void movePane(Pane pane) {
			TranslateTransition transition = new TranslateTransition();
			transition.setDuration(Duration.seconds(0.3));
			transition.setNode(pane);
			
			if(paneHiddenMap.get(pane)) {
			transition.setToX(-520);
			paneHiddenMap.replace(pane, false);
			}else {
				transition.setToX(0);
				paneHiddenMap.replace(pane, true);
			}
			
			transition.play();
		}
		/**
		 * Method is used to show that a circle has been chosen when the user clicks it.
		 */
		public void setCircleChoosen() {
			for(@SuppressWarnings("rawtypes") Map.Entry mapElement :circlesChoosenMap.entrySet()) {
				ImageView circle = (ImageView)mapElement.getKey();
				String imageToSet= (boolean) mapElement.getValue() ? CIRCLE_CHOSEN_IMAGE :CIRCLE_NOTCHOSEN_IMAGE;
				circle.setImage(new Image(imageToSet));
			}
		}
			
}
