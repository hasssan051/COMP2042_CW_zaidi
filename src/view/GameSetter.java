package view;


import java.util.ArrayList;

import model.ActorResources.ActorComponents;
import model.actorRefactored.PlayerEnum;
import model.actorRefactored.IntersectingActors;
import model.actorRefactored.MainPlayer;
import model.actorRefactored.PlayerFactory;
import model.actors.CrocHead;
import model.actors.End;
import model.actors.Log;
import model.actors.Obstacle;
import model.actors.Turtle;
import model.actors.WetTurtle;

/**
 * This class is used to make each of the object that the GameViewManager Class will later render
 * @author HP
 *
 */
public class GameSetter {
	
	private ArrayList<IntersectingActors> objects= new ArrayList<IntersectingActors>();

	private MainPlayer frogger;
	
   
	
	public GameSetter(int numOfLogs, int numOfSlowCars,int numOfFastCars,int numOfLargeTrucks,
			int numOfSmallTrucks,int numOfTurtles,int numOfWetTurtles,int numOfCrocodiles,boolean CrocHead) {
		//objects.clear();
		createLog(numOfLogs, numOfLogs, numOfLogs);
		createSlowCars(numOfSlowCars);
		createFastCars(numOfFastCars);
		createLargeTrucks(numOfLargeTrucks);
		createSmallTrucks(numOfSmallTrucks);
		createTurtle(numOfTurtles);
		createWetTurle(numOfWetTurtles);
		createCrocodilesRight(numOfCrocodiles);
		//createCrocodilesLeft(numOfCrocodiles);
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
		CrocHead crocHead=new CrocHead(ActorComponents.CROCHEAD,65,0,90,6);
		objects.add(crocHead);
	}
	
	/**
	 * Method makes Crocodile Obstacles, moving towards the right, according to the argument passed in and adds it to the objects ArrayList
	 * @param numOfCrocodiles specifies the number of crocodiles that need to be created
	 */
	private void createCrocodilesRight(int numOfCrocodiles) {
		int xpos=0;
		for(int i=0; i<numOfCrocodiles;i++) {
			Obstacle croc = new Obstacle(ActorComponents.CROCODILE, xpos, 440,2);
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
		frogger = PlayerFactory.createPlayer(PlayerEnum.FROGGER);
		objects.add(frogger);
	}
	/**
	 * Makes Turtle Objects according to argument and adds it to the objects ArrayList.
	 * @param turtleNum specifies number of turtle objects that need to be created
	 */

	private void createTurtle(int turtleNum) {
		int xpos=0;
		for(int i=0;i<turtleNum;i++) {
			Turtle turtle =new Turtle(xpos, 376, -1);
			objects.add(turtle);
			xpos+=200;
		}	
	}
	
	/**
	 * Create WetTurtle objects and adds it to the ArrayList . The number that is created is based on total Turtle objects that were created.
	 * @param turtleNum specifies number of WetTurles needed to be created
	 */
	private void createWetTurle(int turtleNum) {
		int xpos=0;
		for(int i=0;i<turtleNum;i++) {
			WetTurtle turtle =new WetTurtle(xpos, 217, -1);
			objects.add(turtle);
			xpos+=200;
		}
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
			Log firstQuadLog = new Log( ActorComponents.LOG3, xpos, 166, 0.75);
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
			Log secondQuadLog = new Log(ActorComponents.LOG, xpos, 276, -2);
			objects.add(secondQuadLog);
			xpos+=400;	 
		}
	}
	
	/**
	 * Creates Log objects for the third row and adds it to the ArrayList.
	 * @param thirdQuadNum specifies number of Log objects to be created for the third row
	 */
	private void createLogForThirdQuad(int thirdQuadNum) {
		//int xDistance= 10;
		int xpos=ActorComponents.LOG3.getSize() ;
		for(int i=0; i < thirdQuadNum; i++) {
			Log thirdQuadLog = new Log(ActorComponents.LOG3, xpos, 329, 0.75);
			objects.add(thirdQuadLog);
			xpos = xpos + ActorComponents.LOG3.getSize();
			//xpos+=220;
		}
	}
	
	/**
	 * Creates Obstacle objects, that will be presented on the GUI as slow cars, it then adds these objects to the ArrayList.
	 * @param carNum specifies how many Obstacle objects will be created as slow cars
	 */
	private void createSlowCars(int carNum) {
		int xpos=100;
		for (int i=0; i< carNum; i++) {
			Obstacle slowCars = new Obstacle(ActorComponents.CAR2, xpos, 597, -1);
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
			Obstacle fastCars = new Obstacle(ActorComponents.CAR, xpos, 490, 5);
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
		Obstacle smallTruck = new Obstacle(ActorComponents.TRUCK1, xpos, 649, 1);
		objects.add(smallTruck);
		xpos +=300;
		}
	}
	
	/**
	 * Creates Obstacle objects that will be presented on the GUI as Large trucks, it then adds these objects to the ArrayList
	 * @param truckNum specifies number of Obstacle objects that will be created as large trucks 
	 */
	
	private void createLargeTrucks(int truckNum) {
		int xDistance= 10;
		int xpos=ActorComponents.TRUCK2.getWidth() + xDistance;
		for (int i=0; i<=truckNum-1; i++) {
			Obstacle largeTruck = new Obstacle(ActorComponents.TRUCK2, xpos, 540, 1);
			objects.add(largeTruck);
			xpos = xpos + ActorComponents.TRUCK2.getWidth() + xDistance;
			}
	}
	
	/**
	 * Gets ArrayList that has Actor objects inside it.
	 * @return returns the objects ArrayList 
	 */
	
	public ArrayList<IntersectingActors> getArrayList(){
		return objects;
	}
	
	/**
	 * Returns an Actor.
	 * @return returns Actor Animal called frogger
	 */
	public IntersectingActors getFrogger() {
		return frogger;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
