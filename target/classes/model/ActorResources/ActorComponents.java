package model.ActorResources;

public enum ActorComponents {
	
	FROGGER("file:src/model/ActorResources/froggerUp.png",
			"file:src/model/ActorResources/froggerDown.png",
			"file:src/model/ActorResources/froggerRight.png",
			"file:src/model/ActorResources/froggerLeft.png",
			40),
	
	FROGGERMOVE("file:src/model/ActorResources/froggerUpJump.png",
			"file:src/model/ActorResources/froggerDownJump.png",
			"file:src/model/ActorResources/froggerRightJump.png",
			"file:src/model/ActorResources/froggerLeftJump.png",
			40),
	
	LOG("file:src/model/Actorresources/logs.png",300),
	LOG3("file:src/model/Actorresources/log3.png",150),
	
	TURTLE("file:src/model/ActorResources/TurtleAnimation1.png",
			"file:src/model/ActorResources/TurtleAnimation2.png",
			"file:src/model/ActorResources/TurtleAnimation3.png",130,130),
	
	WETTURTLE("file:src/model/ActorResources/TurtleAnimation1.png",
			"file:src/model/ActorResources/TurtleAnimation2Wet.png",
			"file:src/model/ActorResources/TurtleAnimation3Wet.png",
			"file:src/model/ActorResources/TurtleAnimation4Wet.png",130,130),
	
	CAR("file:src/model/ActorResources/car1Left.png",
			"file:src/model/ActorResources/car1Right.png",50,50),
	
	TRUCK1("file:src/model/ActorResources/truck1Left.png",
			"file:src/model/ActorResources/truck1Right.png",120,120),
	TRUCK2("file:src/model/ActorResources/truck2Left.png",
			"file:src/model/ActorResources/truck2Right.png",200,200),
	
	CROCODILE("file:src/model/ActorResources/crocodileleft.png",
			"file:src/model/ActorResources/crocodile.png",100,100),
	
	CROCHEAD("file:src/model/ActorResources/crochead.png",65),
	
	CARDEATH("file:src/model/ActorResources/cardeath1.png",
			"file:src/model/ActorResources/cardeath2.png",
			"file:src/model/ActoResources/cardeath3.png"),
	
	WATERDEATH("file:src/model/ActorResources/waterdeath1.png",
			"file:src/model/ActorResources/death/waterdeath2.png",
			"file:src/model/ActorResources/waterdeath3.png",
			"file:src/model/ActorResources/waterdeath4.png");
	
	
	
	
	int size;
	int width;
	int height;
	String objectUrl;
	String urlUp;
	String urlDown;
	String urlLeft;
	String urlRight;
	String urlAnimation1;
	String urlAnimation2;
	String urlAnimation3;
	String urlAnimation4;
	
	
	private ActorComponents(String urlUp, String urlDown,String urlRight, String urlLeft, int size) {
		this.urlUp= urlUp;
		this.urlDown= urlDown;
		this.urlRight= urlRight;
		this.urlLeft=urlLeft;
		this.size=size;
		
	}
	
	private ActorComponents(String objectUrl, int size) {
		this.objectUrl=objectUrl;
		this.size=size;
	}
	
	private ActorComponents(String animation1, String animation2, String animation3, int height,int width) {
		this.urlAnimation1= animation1;
		this.urlAnimation2= animation2;
		this.urlAnimation3= animation3;
		this.height= height;
		this.width= width;
		
	}
	
	private ActorComponents(String animation1, String animation2, String animation3, String animation4, int height, int width) {
		this.urlAnimation1= animation1;
		this.urlAnimation2= animation2;
		this.urlAnimation3= animation3;
		this.urlAnimation4= animation4;
		this.height= height;
		this.width= width;
		
	}
	private ActorComponents(String urlRight, String urlLeft, int height, int width) {
		this.urlRight =urlRight;
		this.urlLeft= urlLeft;
		this.height= height;
		this.width= width;
	}
	
	private ActorComponents(String animation1, String animation2, String animation3) {
		this.urlAnimation1= animation1;
		this.urlAnimation2= animation2;
		this.urlAnimation3= animation3;
			
	}
	private ActorComponents(String animation1, String animation2, String animation3, String animation4) {
		this.urlAnimation1= animation1;
		this.urlAnimation2= animation2;
		this.urlAnimation3= animation3;
		this.urlAnimation4= animation4;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	
	public String getUrlUp() {
		return this.urlUp;
	}
	
	public String getUrlDown() {
		return this.urlDown;
	}
	
	public String getUrlLeft() {
		return this.urlLeft;
	}
	
	public String getUrlRight() {
		return this.urlRight;
	}
	
	public String getUrlAnimation1() {
		return this.urlAnimation1;
	}
	
	public String getUrlAnimation2() {
		return this.urlAnimation2;
	}
	
	public String getUrlAnimation3() {
		return this.urlAnimation3;
	}
	
	public String getUrlAnimation4() {
		return this.urlAnimation4;
	}
	
	public String getObject() {
		return this.objectUrl;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
