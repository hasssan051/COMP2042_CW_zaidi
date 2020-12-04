package Deleted_Discarded;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameViewManager {
	
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;
	private AnchorPane gamePane;
	private Scene gameScene;
	private Stage gameStage;
	
	
	public GameViewManager() {
		initializeStage();
	}
	
	private void initializeStage() {
		gamePane=new AnchorPane();
		gameScene=new Scene(gamePane,GAME_WIDTH,GAME_HEIGHT);
		gameStage.setScene(gameScene);
		
	}

	private void createElement() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	


}
