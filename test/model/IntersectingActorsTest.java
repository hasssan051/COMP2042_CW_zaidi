package model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import model.actorRefactored.IntersectingActors;


class IntersectingActorsTest {
	
	IntersectingActors intersectingActors;
	
	@BeforeEach
	void init() {
		intersectingActors =new IntersectingActors();		
	}
	
	@Test
	void testMove() {
		intersectingActors.move(2,3);
		assertEquals(2, intersectingActors.getX(),"Actor is not moving properly on the x axis");
		assertEquals(3, intersectingActors.getY(),"Actor is not moving properly on the y axis");
	}

}
