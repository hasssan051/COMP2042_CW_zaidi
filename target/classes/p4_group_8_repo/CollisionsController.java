/*
 * package p4_group_8_repo;
 * 
 * import java.util.ArrayList;
 * 
 * import javafx.scene.Node; import javafx.scene.image.ImageView; import
 * model.Actor; import model.Animal; import model.End; import model.Log; import
 * model.Turtle; import model.WetTurtle; import view.GameSetter; import
 * view.World;
 * 
 * 
 * public abstract class CollisionsController extends ImageView{
 * 
 * private boolean noMove;
 * 
 * private int points=0; private int end=0;
 * 
 * private boolean crocDeath; private boolean carDeath; private boolean
 * waterDeath;
 * 
 * private int crocodileD=0; private int carD = 0;
 * 
 * private ArrayList<End> inter = new ArrayList<>();
 * 
 * 
 * public CollisionsController(Animal frogger) { isColiidingWithEnd(frogger);
 * isCollidingWithLog(frogger); isCollidingWithTurtle(frogger);
 * isCollidingWithWetTurtle(frogger); }
 * 
 * public CollisionsController(Animal frogger) {
 * 
 * }
 * 
 * public <A extends Actor> java.util.List<A>
 * getIntersectingObjects(java.lang.Class<A> cls){ ArrayList<A> someArray = new
 * ArrayList<A>(); //new array list of type A which is an actor for (A actor:
 * getWorld().getObjects(cls)) { if ( actor.intersects(this.getBoundsInLocal()))
 * { someArray.add(actor); } } return someArray; }
 * 
 * private World getWorld() { // TODO Auto-generated method stub return (World)
 * getParent(); }
 * 
 * public void isCollidingWithLog(Animal frogger) { if
 * (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
 * if(getIntersectingObjects(Log.class).get(0).getLeft()) frogger.move(-2,0);
 * else frogger.move (.75,0); } }
 * 
 * public void isCollidingWithTurtle(Animal frogger) { if
 * (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
 * frogger.move(-1,0); } }
 * 
 * public void isCollidingWithWetTurtle(Animal frogger) { if
 * (getIntersectingObjects(WetTurtle.class).size() >= 1) { if
 * (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) { //waterDeath =
 * true; } else { frogger.move(-1,0); } } }
 * 
 * public void isCollidingWithEnd(Animal frogger) { if
 * (getIntersectingObjects(End.class).size() >= 1) { inter = (ArrayList<End>)
 * getIntersectingObjects(End.class); if (inter.get(0).isActivated()) { //end--;
 * points-=50; setFroggerToStart(frogger); } //points+=50; //changeScore = true;
 * //w=800; //getIntersectingObjects(End.class).get(0).setEnd(); //end++;
 * //setX(300); //setY(679.8+movement); }
 * 
 * }
 * 
 * public void isCollidingWithCrocodile(Animal frogger) {
 * if(getIntersectingObjects(Crocodile.class).size()>=1) {
 * 
 * } }
 * 
 * public void isCollidingWithCrocHead(Animal frogger) {
 * 
 * } private void setFroggerToStart(Animal frogger) { frogger.setX(300);
 * frogger.setY(679.8); }
 * 
 * public abstract void act(long now);
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */