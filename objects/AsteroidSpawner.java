package objects;

import java.io.IOException;

import core.Timer;
import update.Updateable;
import update.Updater;

public class AsteroidSpawner implements Updateable{
	Timer timer = new Timer(500);
	
	public AsteroidSpawner() {
		Updater.addUpdateableObject(this);
	}

	@Override
	public void update() throws IOException {
		if(timer.isRinging()) {
			new Asteroid();
			timer.resetTimer();
		}
	}
}
