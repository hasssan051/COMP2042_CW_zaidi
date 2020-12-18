/*
 * package p4_group_8_repo;
 * 
 * import javafx.event.EventHandler; import javafx.scene.Node; import
 * javafx.scene.image.Image; import javafx.scene.input.KeyCode; import
 * javafx.scene.input.KeyEvent; import model.FroggerButton;
 * 
 * public class AnimalController extends Node{ Image imgW1; Image imgA1; Image
 * imgS1; Image imgD1; Image imgW2; Image imgA2; Image imgS2; Image imgD2;
 * 
 * private boolean noMove = false; private static final double movement =
 * 13.3333333*2; //moves in Y direction private static final double movementX =
 * 10.666666*2; //moves in X direction private static final int imgSize = 40;
 * 
 * public AnimalController(Animal frogger) {
 * 
 * createKeyListner(frogger); imgW1 = new
 * Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true,
 * true); imgA1 = new Image("file:src/p4_group_8_repo/froggerLeft.png", imgSize,
 * imgSize, true, true); imgS1 = new
 * Image("file:src/p4_group_8_repo/froggerDown.png", imgSize, imgSize, true,
 * true); imgD1 = new Image("file:src/p4_group_8_repo/froggerRight.png",
 * imgSize, imgSize, true, true); imgW2 = new
 * Image("file:src/p4_group_8_repo/froggerUpJump.png", imgSize, imgSize, true,
 * true); imgA2 = new Image("file:src/p4_group_8_repo/froggerLeftJump.png",
 * imgSize, imgSize, true, true); imgS2 = new
 * Image("file:src/p4_group_8_repo/froggerDownJump.png", imgSize, imgSize, true,
 * true); imgD2 = new Image("file:src/p4_group_8_repo/froggerRightJump.png",
 * imgSize, imgSize, true, true);
 * 
 * }
 * 
 * private void createKeyListner(Animal frogger) { setOnKeyPressed(new
 * EventHandler<KeyEvent>() {
 * 
 * @Override public void handle(KeyEvent event) { if(noMove) {
 * 
 * } else { if (event.getCode() == KeyCode.W) { frogger.move(0, -movement);
 * setImage(imgW2); //second = true; } else if (event.getCode() == KeyCode.A) {
 * frogger.move(-movementX, 0); setImage(imgA2); // second = true; } else if
 * (event.getCode() == KeyCode.S) { frogger.move(0, movement); setImage(imgS2);
 * //second = true; } else if (event.getCode() == KeyCode.D) {
 * frogger.move(movementX, 0); setImage(imgD2); //second = true; } }
 * 
 * } });
 * 
 * setOnKeyReleased(new EventHandler<KeyEvent>() {
 * 
 * @Override public void handle(KeyEvent event) { if (noMove) {} else { if
 * (event.getCode() == KeyCode.W) { //agar Y value of the frog is less than
 * screen size if (getY() < w) { changeScore = true; //than changescore should
 * be true w = getY(); points+=10; //points should be added by 10 } //always do
 * according to the movement no matter where the frog is at in the screen
 * frogger.move(0, -movement); setImage(imgW1); //second = false; } //otherwise
 * do the normal shit (as soon as key released position frog according to which
 * key was pressed else if (event.getCode() == KeyCode.A) {
 * frogger.move(-movementX, 0); setImage(imgA1); // second = false; } else if
 * (event.getCode() == KeyCode.S) { frogger.move(0, movement); setImage(imgS1);
 * //second = false; } else if (event.getCode() == KeyCode.D) {
 * frogger.move(movementX, 0); setImage(imgD1); // second = false; } }
 * 
 * } });
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */