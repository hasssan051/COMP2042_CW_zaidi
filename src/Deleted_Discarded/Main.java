/*
 * package Deleted_Discarded;
 * 
 * import java.io.File; import java.util.List; import java.util.Random;
 * 
 * import javafx.animation.AnimationTimer; import
 * javafx.application.Application; import javafx.fxml.FXMLLoader; import
 * javafx.scene.Node; import javafx.scene.Parent; import javafx.scene.Scene;
 * import javafx.scene.control.Alert; import
 * javafx.scene.control.Alert.AlertType; import javafx.scene.image.Image; import
 * javafx.scene.image.ImageView;
 * 
 * import javafx.scene.media.Media; import javafx.scene.media.MediaPlayer;
 * import javafx.scene.text.Text; import javafx.stage.Stage; import
 * javafx.util.Duration; import p4_group_8_repo.Animal; import
 * p4_group_8_repo.World;
 * 
 * public class Main extends Application { AnimationTimer timer; World
 * background; Animal animal; private MediaPlayer mediaPlayer;
 * 
 * private static final String
 * BACKGROUND_IMAGE="file:src/p4_group_8_repo/iKogsKW.png"; private static final
 * String LOG_URL_1 ="file:src/p4_group_8_repo/log3.png"; private static final
 * String LOG_URL_2 ="file:src/p4_group_8_repo/logs.png"; private static final
 * String SMALL_TRUCK_URL="file:src/p4_group_8_repo/truck1Right.png"; private
 * static final String
 * LARGE_TRUCK_URL="file:src/p4_group_8_repo/truck2Right.png"; private static
 * final String CAR_URL= "file:src/p4_group_8_repo/car1Left.png"; private static
 * final String MUSIC_URL=
 * "src/p4_group_8_repo/Frogger Main Song Theme (loop).mp3";
 * 
 * public static void main(String[] args) { launch(args); }
 * 
 * @Override public void start(Stage primaryStage) throws Exception { background
 * = new World(); //background is a world object
 * 
 * 
 * Scene scene = new Scene(background,600,800);
 * 
 * createBackground();
 * 
 * createLog(3,2,3);
 * 
 * createTurtle(2);
 * 
 * background.add(new End(12,96)); background.add(new End(140,96));
 * background.add(new End(140 + 141-13,96)); background.add(new End(140 +
 * 141-13+141-13+1,96)); background.add(new End(140 +
 * 141-13+141-13+141-13+3,96));
 * 
 * animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");
 * background.add(animal);
 * 
 * createSmallTrucks(3);
 * 
 * createLargeTrucks(2);
 * 
 * createSlowCars(4);
 * 
 * createFastCars(1);
 * 
 * 
 * 
 * background.add(new Digit(0, 30, 360, 25));
 * 
 * primaryStage.setScene(scene); primaryStage.show(); start(); }
 * 
 * private void createTurtle(int turtleNum) { int xpos=300; for(int
 * i=0;i<turtleNum;i++) { Turtle turtle =new Turtle(xpos, 376, -1, 130, 130);
 * background.add(turtle); xpos+=200; } createWetTurle(turtleNum*2); }
 * 
 * private void createWetTurle(int turtleNum) { int xpos=200; for(int
 * i=0;i<turtleNum;i++) { WetTurtle turtle =new WetTurtle(xpos, 217, -1, 130,
 * 130); background.add(turtle); xpos+=200; } background.add(new WetTurtle(700,
 * 376, -1, 130, 130));
 * 
 * }
 * 
 * private void createSlowCars(int carNum) { int xpos=100; for (int i=0; i<
 * carNum; i++) { Obstacle smallTruck = new Obstacle(CAR_URL, xpos, 597, -1, 50,
 * 50); background.add(smallTruck); xpos +=150; }
 * 
 * }
 * 
 * private void createFastCars(int carNum) { int xpos=500; for (int i=0; i<
 * carNum; i++) { Obstacle smallTruck = new Obstacle(CAR_URL, xpos, 490, 5, 50,
 * 50); background.add(smallTruck); //xpos +=150; } } private void
 * createSmallTrucks(int truckNum) { int xpos=0; for (int i=0; i< truckNum; i++)
 * { Obstacle smallTruck = new Obstacle(SMALL_TRUCK_URL, xpos, 649, 1, 120,
 * 120); background.add(smallTruck); xpos +=300; } }
 * 
 * private void createLargeTrucks(int truckNum) { int xpos=0; for (int i=0; i<
 * truckNum; i++) { Obstacle smallTruck = new Obstacle(LARGE_TRUCK_URL, xpos,
 * 540, 1, 200, 200); background.add(smallTruck); xpos +=500; } }
 * 
 * private void createLog(int firstQuadNum, int secondQuad, int thirdQuadNum) {
 * 
 * createLogForFirstQuad(firstQuadNum);
 * 
 * createLogForSecondQuad(secondQuad);
 * 
 * createLogForThirdQuad(thirdQuadNum); }
 * 
 * private void createLogForFirstQuad(int firstQuadNum){ int xpos=0; for(int
 * i=0; i < firstQuadNum; i++) { Log firstQuadLog = new Log( LOG_URL_1,150,
 * xpos, 166, 0.75); background.add(firstQuadLog); xpos+=276; } }
 * 
 * private void createLogForSecondQuad(int secondQuadNum){ int xpos=0; for(int
 * i=0; i < secondQuadNum; i++) { Log secondQuadLog = new Log(LOG_URL_2,300,
 * xpos, 276, -2); background.add(secondQuadLog); xpos+=400;
 * 
 * } }
 * 
 * private void createLogForThirdQuad(int thirdQuadNum) { int xpos=50; for(int
 * i=0; i < thirdQuadNum; i++) { Log thirdQuadLog = new Log(LOG_URL_1,150, xpos,
 * 329, 0.75); background.add(thirdQuadLog); xpos+=220; } }
 * 
 * private void createBackground() { ImageView backgroundImage= new ImageView();
 * backgroundImage.setImage( new Image(BACKGROUND_IMAGE,600,800,true,false));
 * background.add(backgroundImage); }
 * 
 * public void createTimer() { timer = new AnimationTimer() {
 * 
 * @Override public void handle(long now) {
 * 
 * List<Actor> actors = background.getObjects(Actor.class); for (Actor anActor:
 * actors) { anActor.act(now); } if (animal.changeScore()) {
 * setNumber(animal.getPoints()); } if (animal.getStop()) {
 * System.out.print("STOPP:"); stopMusic(); stop(); stop(); Alert alert = new
 * Alert(AlertType.INFORMATION); alert.setTitle("You Have Won The Game!");
 * alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
 * alert.setContentText("Highest Possible Score: 800"); alert.show(); } } }; }
 * 
 * public void start() { //playMusic(); createTimer(); timer.start(); }
 * 
 * public void playMusic() { String musicFile = MUSIC_URL; Media sound = new
 * Media(new File(musicFile).toURI().toString()); mediaPlayer = new
 * MediaPlayer(sound); mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
 * mediaPlayer.play(); } public void stopMusic() { mediaPlayer.stop(); }
 * 
 * public void setNumber(int n) { int shift = 0; while (n > 0) { int d = n / 10;
 * int k = n - d * 10; n = d; background.add(new Digit(k, 30, 360 - shift, 25));
 * shift+=30; } } }
 */