package objects;

import java.io.IOException;

import core.Timer;
import render.Renderable;
import update.Updateable;
import update.Updater;

public class EnemySpaceshipSpawner implements Updateable{
	private static final int spawnTimeMillis = 500;
	Timer timer = new Timer(spawnTimeMillis);
	
	private static final String ID = "enemyspaceshipspawner";
	
	public EnemySpaceshipSpawner() {
		Updater.addUpdateableObject(this);
	}

	@Override
	public void update() throws IOException {
		if(timer.isRinging()) {
			new EnemySpaceship();
			timer.resetTimer();
		}
	}
	
	@Override
	public String getID() {
		return ID;
	}
	
	@Override
	public Renderable getRenderable() {
		return null;
	}
}
