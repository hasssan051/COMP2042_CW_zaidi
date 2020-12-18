package model.actorRefactored;

import view.World;

public interface ActorsInterface {
	
	/**
	 * Method used in order to get the Pane in which the actor resides
	 * @return return pane actor residing in as a World object 
	 */
	public abstract World getWorld();
	
	/**
	 * Method used in order to check for intersecting between two objects 
	 * @param <A> type of class to check for an interaction
	 * @param cls object of class to check for interaction
	 * @return returns an array containing objects intersected with
	 */
	public abstract <A extends IntersectingActors> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls);

} 
