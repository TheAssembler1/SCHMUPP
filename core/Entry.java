package core;

import render.Renderer;
import objects.Spaceship;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import update.Updater;
import objects.EnemySpaceshipSpawner;
import objects.Background;
import objects.EnemySpaceship;

public class Entry{
	public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException{
		Window window = new Window("SCHMUPP", Window.getWinWidth(), Window.getWinHeight());
		Renderer renderer = new Renderer();

		window.addKeyListener(new Input());
		window.add(renderer);
		window.packWindow();
		window.setVisible(true);
	
		boolean runGame = true;
		
		new Spaceship((Window.getWinWidth() / 2) - (Spaceship.width / 2), Window.getWinHeight() - 150);
		new Background(-Window.getWinHeight());
		new EnemySpaceshipSpawner();
		new EnemySpaceship();
		
		FPS.calcBeginTime();
		while(runGame){
			Updater.update();
			renderer.repaint();
			FPS.calcDeltaTime();
		}
	}
}
