package application;
	
import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class Main extends Application {
	Stage primaryStage;
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage=primaryStage;
		
		Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		
		Scene scene = new Scene(root, 800, 600);
	    
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public Stage getScene() {
		return primaryStage;
	}
}
