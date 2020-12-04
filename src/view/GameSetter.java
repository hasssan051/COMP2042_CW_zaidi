package view;


import java.util.ArrayList;

import model.Actor;
import model.Animal;
import model.CrocHead;
import model.Crocodile;
import model.End;
import model.Log;
import model.Obstacle;
import model.Turtle;
import model.WetTurtle;

/**
 * This class is used to make each of the object that the GameViewManager Class will later render
 * @author HP
 *
 */
public class GameSetter {
	
	private ArrayList<Actor> objects= new ArrayList<Actor>();

	private Actor frogger;
	
	private static final String LOG_URL_1 = "file:src/model/ActorResources/log3.png";
	private static final String LOG_URL_2 = "file:src/model/ActorResources/logs.png";
	private static final String SMALL_TRUCK_URL = "file:src/model/ActorResources/truck1Right.png";
	private static final String LARGE_TRUCK_URL = "file:src/model/ActorResources/truck2Right.png";
    private static final String CAR_URL = "file:src/model/ActorResources/car1Left.png";
	private static final String FROGGER_URL = "file:src/model/ActorResources/froggerUp.png";
    private static final String CROCODILE_RIGHT = "file:src/model/ActorResources/crocodile.png";
    private static final String CROCODILE_LEFT = "file:src/model/ActorResources/crocodileleft.png";
    private static final String CROC_HEAD_= "file:src/model/ActorResources/crochead.png";
	
	public GameSetter(int numOfLogs, int numOfCars, int numOfTrucks, int numOfTurtles, int numOfCrocodiles, boolean CrocHead) {
		//objects.clear();
		createLog(numOfLogs, (int)Math.ceil(numOfLogs/2), numOfLogs);
		createSlowCars(numOfCars);
		createFastCars(numOfCars/2);
		createLargeTrucks(numOfTrucks);
		createSmallTrucks(numOfTrucks/2);
		createTurtle(numOfTurtles);
		createWetTurle(numOfTurtles*2-1 );
		createCrocodilesRight(numOfCrocodiles);
		createCrocodilesLeft(numOfCrocodiles);
		createEnd();
		if(CrocHead) {
			createCrocHeads();
		}
		makeFrogger();
		
	}
	
	/**
	 * This method makes a crocHead object and then adds it to the objects ArrayList
	 */
	private void createCrocHeads() {
		CrocHead crocHead=new CrocHead(CROC_HEAD_,65,0,65,6);
		objects.add(crocHead);
	}
	
	/**
	 * Method makes Crocodile Obstacles, moving towards the right, according to the argument passed in and adds it to the objects ArrayList
	 * @param numOfCrocodiles specifies the number of crocodiles that need to be created
	 */
	private void createCrocodilesRight(int numOfCrocodiles) {
		int xpos=0;
		for(int i=0; i<numOfCrocodiles;i++) {
			Obstacle croc = new Obstacle(CROCODILE_RIGHT, xpos, 200,2,120,120);
			objects.add(croc);
			xpos+=400;
		}
		
	}
	/**
	 * Method makes Crocodile Obstacles, moving towards the right, according to the argument passed in and adds it to the objects ArrayList
	 * @param numOfCrocodiles specifies the number of crocodiles that need to be created
	 */
	private void createCrocodilesLeft(int numOfCrocodiles) {
		int xpos=0;
		for(int i=0; i<numOfCrocodiles;i++) {
			Obstacle croc = new Obstacle(CROCODILE_LEFT, xpos, 276, -2,120,120);
			objects.add(croc);
			xpos+=400;
		}
		
	}
	
	/**
	 * Create five End objects and adds it to the objects ArrayList
	 */
	private void createEnd() {
		int xpos= 12; //128++
		for(int i=0;i<5;i++) {
			End end =new End(xpos, 96);
			objects.add(end);
			xpos+=128;
		}	
	}
	
	/**
	 * Makes Animal object called frogger and adds it to the ArrayList 
	 */

	private void makeFrogger() {
		frogger = new Animal(FROGGER_URL);
		objects.add(frogger);
	}
	/**
	 * Makes Turtle Objects according to argument and adds it to the objects ArrayList.
	 * @param turtleNum specifies number of turtle objects that need to be created
	 */

	private void createTurtle(int turtleNum) {
		int xpos=300;
		for(int i=0;i<turtleNum;i++) {
			Turtle turtle =new Turtle(xpos, 376, -1, 130, 130);
			objects.add(turtle);
			xpos+=200;
		}
	createWetTurle(turtleNum*2);	
	}
	
	/**
	 * Create WetTurtle objects and adds it to the ArrayList . The number that is created is based on total Turtle objects that were created.
	 * @param turtleNum specifies number of WetTurles needed to be created
	 */
	private void createWetTurle(int turtleNum) {
		int xpos=200;
		for(int i=0;i<turtleNum;i++) {
			WetTurtle turtle =new WetTurtle(xpos, 217, -1, 130, 130);
			objects.add(turtle);
			xpos+=200;
		}
		objects.add(new WetTurtle(700, 376, -1, 130, 130));
		
	}
	
	/**
	 * Is a container method that passes in values that it receives to other methods in order to create Logs
	 * @param firstQuadNum specifies number of Log objects to be created for the first row
	 * @param secondQuad specifies number of Log Objects to be created for the second row
	 * @param thirdQuadNum specifies number of Log objects to be created for the third row
	 */
	private void createLog(int firstQuadNum, int secondQuad, int thirdQuadNum) {
		
		createLogForFirstQuad(firstQuadNum);
		
		createLogForSecondQuad(secondQuad);
		
		createLogForThirdQuad(thirdQuadNum);		
		
	}
	/**
	 * Creates Log objects for the first row and adds it to the ArrayList	
	 * @param firstQuadNum specifies number of Log objects to be created for the first row
	 */
	private void createLogForFirstQuad(int firstQuadNum){
		int xpos=0;
		for(int i=0; i < firstQuadNum; i++) {
			Log firstQuadLog = new Log( LOG_URL_1,150, xpos, 166, 0.75);
			objects.add(firstQuadLog);
			xpos+=276;
		}
	}
	
	/**
	 * Creates Log objects for the second row and adds it to the ArrayList	
	 * @param secondQuadNum specifies number of Log objects to be created for the second row
	 */
	private void createLogForSecondQuad(int secondQuadNum){
		int xpos=0;
		for(int i=0; i < secondQuadNum; i++) {
			Log secondQuadLog = new Log(LOG_URL_2,300, xpos, 276, -2);
			objects.add(secondQuadLog);
			xpos+=400;	 
		}
	}
	
	/**
	 * Creates Log objects for the third row and adds it to the ArrayList.
	 * @param thirdQuadNum specifies number of Log objects to be created for the third row
	 */
	private void createLogForThirdQuad(int thirdQuadNum) {
		int xpos=50;
		for(int i=0; i < thirdQuadNum; i++) {
			Log thirdQuadLog = new Log(LOG_URL_1,150, xpos, 329, 0.75);
			objects.add(thirdQuadLog);
			xpos+=220;
		}
	}
	
	/**
	 * Creates Obstacle objects, that will be presented on the GUI as slow cars, it then adds these objects to the ArrayList.
	 * @param carNum specifies how many Obstacle objects will be created as slow cars
	 */
	private void createSlowCars(int carNum) {
		int xpos=100;
		for (int i=0; i< carNum; i++) {
			Obstacle slowCars = new Obstacle(CAR_URL, xpos, 597, -1, 50, 50);
			objects.add(slowCars);
			xpos +=150;
			}
	
	}
	
	/**
	 * Creates Obstacle objects that will be presented on the GUI as fast cars, it then adds these objects to the ArrayList.
	 * @param carNum specifies number of Obstacle objects that will be created as fast cars
	 */
	private void createFastCars(int carNum) {
		int xpos=500;
		for (int i=0; i< carNum; i++) {
			Obstacle fastCars = new Obstacle(CAR_URL, xpos, 490, 5, 50, 50);
			objects.add(fastCars);
			xpos +=150;
			}
	}
	
	/**
	 * Creates Obstacle objects that will be presented on the GUI as Small trucks, it then adds these objects to the ArrayList
	 * @param truckNum specifies number of Obstacle objects that will be created as small trucks 
	 */
	private void createSmallTrucks(int truckNum) {
	int xpos=0;
	for (int i=0; i< truckNum; i++) {
		Obstacle smallTruck = new Obstacle(SMALL_TRUCK_URL, xpos, 649, 1, 120, 120);
		objects.add(smallTruck);
		xpos +=300;
		}
	}
	
	/**
	 * Creates Obstacle objects that will be presented on the GUI as Large trucks, it then adds these objects to the ArrayList
	 * @param truckNum specifies number of Obstacle objects that will be created as large trucks 
	 */
	
	private void createLargeTrucks(int truckNum) {
		int xpos=0;
		for (int i=0; i< truckNum; i++) {
			Obstacle largeTruck = new Obstacle(LARGE_TRUCK_URL, xpos, 540, 1, 200, 200);
			objects.add(largeTruck);
			xpos +=500;
			}
	}
	
	/**
	 * Gets ArrayList that has Actor objects inside it.
	 * @return returns the objects ArrayList 
	 */
	
	public ArrayList<Actor> getArrayList(){
		return objects;
	}
	
	/**
	 * Returns an Actor.
	 * @return returns Actor Animal called frogger
	 */
	public Actor getFrogger() {
		return frogger;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
