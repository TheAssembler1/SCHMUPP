package update;

import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Updater{
	private static ArrayList<Updateable> updateableObjects = new ArrayList<Updateable>();
	private static ArrayList<Updateable> addUpdateableObjects = new ArrayList<Updateable>();
	private static ArrayList<Updateable> removeUpdateableObjects = new ArrayList<Updateable>();
	
	public static void update() throws IOException, UnsupportedAudioFileException, LineUnavailableException{
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
	
	public static ArrayList<Updateable> getUpdateableObjects() {
		return updateableObjects;
	}
}