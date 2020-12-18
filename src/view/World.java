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
import model.actorRefactored.IntersectingActors;

/**
 * This class is the Pane in which all the objects of the game will reside. The class is used to build the scene of the game. 
 * It check for any changes in the scene and updates it accordingly on the screen. 
 * @author HP
 *
 */
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
    
	
    /**
     * The method can be used to add new nodes on the World pane.
     * @param node node that is to be on the screen.
     */
    public void add(Node node) {
        getChildren().add(node);
    }
    
    /**
     * The method is used to remove a specific node from the World pane.
     * @param node node that needs to be removed from the World pane.
     */
    public void remove(Node node) {
        getChildren().remove(node);
    }
    
   /**
    * This method is used to get Objects from the World pane for a particular object of IntersectingActors.
    * @param <A> the specific child class of IntersectingActors for which objects are required 
    * @param cls the object itself
    * @return returns an ArrayList of objects the specific child class of IntersectingActors found on the World pane
    */
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
