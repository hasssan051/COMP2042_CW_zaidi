package model;

import java.util.ArrayList;

import application.*;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Animal extends Actor {
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	
	private int points = 0; //keeps track of the points in the game 
	private int end = 0;
	
	//the variables below are used for the movement of the frog
	//private boolean second = false;
	private boolean noMove = false;
	
	private static final String FROGGER_URL_STRING="";
	private static final double movement = 13.3333333*2; //moves in Y direction
	private static final double movementX = 10.666666*2; //moves in X direction 
	private static final int 	imgSize = 40;  //is used as an argument in Image constructor to set the size of images as they are initialized 
	
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean crocodileDeath= false;
	
	private boolean stop = false;
	private boolean changeScore = false;
	
	private boolean hasStageChanged=false;
	
	private int Death=0;
	private int carD = 0;
	private double w = 800; 
	//this is to check if the frog is at the end or not
	ArrayList<End> inter = new ArrayList<>();
	ArrayList<End> activatedEnds =new ArrayList<End>();
	//why does everything happen in the constructor with this class
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true)); //Image constructor used as argument to setImage method
		//initial position of the frog
		//AnimalController controller= new AnimalController(this);
		setFroggerToStart();
		//initializing the images 
		imgW1 = new Image("file:src/model/ActorResources/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/model/ActorResources/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/model/ActorResources/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/model/ActorResources/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/model/ActorResources/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/model/ActorResources/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/model/ActorResources/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/model/ActorResources/froggerRightJump.png", imgSize, imgSize, true, true);
		
		
		createKeyListner();
	}
	
	private void createKeyListner() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(noMove) {
					
				}
				else {
					if (event.getCode() == KeyCode.W) {	            	
		                move(0, -movement);
		                setImage(imgW2);
		                //second = true;
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-movementX, 0);
		            	 setImage(imgA2);
//		            	 second = true;
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, movement);
		            	 setImage(imgS2);
		            	 //second = true;
		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(movementX, 0);
		            	 setImage(imgD2);
		            	 //second = true;
		            }
				}
				
			}
		});
		
		setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	  
					//agar Y value of the frog is less than screen size
					if (getY() < w) {
						changeScore = true; //than changescore should be true 
						w = getY();
						points+=10; //points should be added by 10
					}
					//always do according to the movement no matter where the frog is at in the screen
	                move(0, -movement);
	                setImage(imgW1);
	                //second = false;
	            }
				//otherwise do the normal shit (as soon as key released position frog according to which key was pressed 
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA1);
	            	// second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS1);
	            	 //second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD1);
	            	// second = false;
	            }
	        }
				
			}
		});
		
	}

	@Override
	public void act(long now) {		
		froggerInBound();
		
		ifCarDeath(now); 
		
		ifWaterDeath(now);
		
		ifCrocodileDeath(now);
		
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		
		if(getIntersectingObjects(Crocodile.class).size()>=1) {
			crocodileDeath=true;
		}
		else if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (inter.get(0).isActivated()) {
				points-=70;
				waterDeath=true;
				setFroggerToStart();
				
			}else {
				activatedEnds.add(inter.get(0));
			}
			points+=50;
			changeScore = true;
			w=800;
			inter.get(0).setEnd();
			end++;
			//hasStageEnded();
			setFroggerToStart();
		}
		else if (getY()<413){
			waterDeath = true;
			setFroggerToStart();
		}
	}
	
	public boolean hasStageEnded() {
		stageEnded();
		if(hasStageChanged) {
			hasStageChanged=false;
			return true;
		}else {
			return false;
		}
	}
	private void stageEnded() {
		if(activatedEnds.size()==5) {
			//points=0;
			noMove = false;
			carDeath = false;
			waterDeath = false;
			crocodileDeath= false;
			stop = false;
			changeScore = false;
			carD = 0;
			w = 800; 
			end=0;
			for(End ends: activatedEnds ) {
				ends.unsetEnd(); 
			}
			activatedEnds.removeAll(activatedEnds);
			setFroggerToStart();
			createKeyListner();
			hasStageChanged=true;
			
		}else {
			hasStageChanged=false;
		}
		
		
	}

	private void ifWaterDeath(long now) {
		
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		
		if (waterDeath) {
			
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/model/ActorResources/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/model/ActorResources/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/model/ActorResources/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/model/ActorResources/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				setFroggerToStart();
				waterDeath = false;
				Death++;
				carD = 0;
				setImage(new Image("file:src/model/ActorResources/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		
	}

	private void ifCarDeath(long now) {
		
		if (carDeath) {
			
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/model/ActorResources/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/model/ActorResources/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/model/ActorResources/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setFroggerToStart();
				carDeath = false;
				Death++;
				carD = 0;
				setImage(new Image("file:src/model/ActorResources/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		
	}
	private void ifCrocodileDeath(long now) {
		if (crocodileDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/model/ActorResources/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/model/ActorResources/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/model/ActorResources/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setFroggerToStart();
				crocodileDeath= false;
				Death++;
				carD = 0;
				setImage(new Image("file:src/model/ActorResources/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		
	}
	
	public boolean isGameOver() {
		//System.out.println(Death);
		return Death>3;
		
	}
	
	private void Death(long now, String death) {
		
	}
	
	
	private void froggerInBound() {
		if (getY()<0 || getY()>734) {
			setFroggerToStart();
		}
		
		if (getX()<0) {
			move(movement*2, 0);
		}
		
		 if (getX()>600) { move(-movement*2, 0); }
		
	}

	/*
	 * public boolean getStop() { return end==5; }
	 */
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	/*
	 * public int getEnd() { return end; }
	 */
	private void setFroggerToStart() {
		setX(300);
		setY(679.8+movement);
	}
	public Image getFroggerUp() {
		return imgW1;
	}
	

}
