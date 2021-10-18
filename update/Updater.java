package update;

import java.util.ArrayList;

public class Updater{
	private static ArrayList<Updateable> updateableObjects = new ArrayList<Updateable>();
	private static ArrayList<Updateable> addUpdateableObjects = new ArrayList<Updateable>();
	private static ArrayList<Updateable> removeUpdateableObjects = new ArrayList<Updateable>();
	
	public static void update(){
		for(Updateable object: updateableObjects)
			object.update();
		
		updateableObjects.removeAll(removeUpdateableObjects);
		updateableObjects.addAll(addUpdateableObjects);
		
		addUpdateableObjects.clear();
		removeUpdateableObjects.clear();
	}
	
	public static void addUpdateableObject(Updateable object){
		addUpdateableObjects.add(object);
	}
	
	public static void removeUpdateableObject(Updateable object){
		removeUpdateableObjects.add(object);
	}
}