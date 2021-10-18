package core;

import render.Renderer;
import objects.Spaceship;
import java.io.IOException;

import update.Updater;

import objects.Background;

public class Entry{
	public static void main(String[] args) throws IOException{
		Window window = new Window("SCHMUPP", Window.getWinWidth(), Window.getWinHeight());
		Renderer renderer = new Renderer();
		Updater updater = new Updater();

		window.addKeyListener(new Input());
		window.add(renderer);
		window.packWindow();
		window.setVisible(true);
	
		boolean runGame = true;
		
		new Spaceship((Window.getWinWidth() / 2) - (Spaceship.width / 2), Window.getWinHeight() - 150);
		new Background(0);
		new Background(-Window.getWinHeight());
		
		FPS.calcBeginTime();
		while(runGame){
			updater.update();
			renderer.repaint();
			FPS.calcDeltaTime();
		}
	}
}
