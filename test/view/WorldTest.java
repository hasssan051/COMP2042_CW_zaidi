package view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.control.Button;
import model.actorRefactored.IntersectingActors;

class WorldTest {
	
	World background;
	
	@BeforeEach
	void init() {
		IntersectingActors a= new IntersectingActors();
		IntersectingActors b= new IntersectingActors();
		IntersectingActors c= new IntersectingActors();
		background=new World();
		background.add(a);
		background.add(b);
		background.add(c);
	}
	
	@Test
	void testGetObjects() {
		assertEquals(3, background.getObjects(IntersectingActors.class).size());
	}
}
