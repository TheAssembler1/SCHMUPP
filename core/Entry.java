package core;

import render.Renderer;

public class Entry{
	public static void main(String[] args){
		Window window = new Window("SCHMUPP", Window.getWinWidth(), Window.getWinHeight());
		Renderer renderer = new Renderer();

		window.addKeyListener(new Input());
		window.add(renderer);
		window.packWindow();
		window.setVisible(true);
	
		boolean runGame = true;
		
		FPS.calcBeginTime();
		while(runGame){
			//update the game state

			//recalc delta time
			FPS.calcDeltaTime();
		}
	}
}
