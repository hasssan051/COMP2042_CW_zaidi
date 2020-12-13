package view;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.IntersectingActors;


public class World extends Pane {
    public World() {
    	createSceneChangeListner();
    }

    private void createSceneChangeListner() {
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<IntersectingActors> myActors = getObjects(IntersectingActors.class);
							for (IntersectingActors anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<IntersectingActors> myActors = getObjects(IntersectingActors.class);
							for (IntersectingActors anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
		
	}
    
	
    
    public void add(Node node) {
        getChildren().add(node);
    }

    public void remove(Node node) {
        getChildren().remove(node);
    }
    //the method below will return a list of Actor Objects //the method takes in an actor object as a parameter 
    @SuppressWarnings("unchecked")
	public <A extends IntersectingActors> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        //checking if the object cls that we have passed into the method is an instance of Node class
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n); //if it is we pass this object into our array
            }
        }
        return someArray;
    }


	
}
