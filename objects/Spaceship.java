package objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import render.Renderer;
import render.Renderable;

import update.Updateable;
import update.Updater;

import core.Input;
import core.Sound;
import core.Timer;
import core.FPS;
import core.Window;

public class Spaceship implements Renderable, Updateable{
	public static double width = 75;
	private static double height = 75;
	private double x;
	private double y;
	
	private int layer = 2;
	
	private static BufferedImage spaceShip;
	
	private double speed = 200;
	
	private static int shootingTimerMillis = 500;
	
	Timer timer = new Timer(shootingTimerMillis);
	
	private boolean drawCollisionBox = true;
	
	private static final String ID = "spaceship";
	
	public Spaceship(double x, double y) throws IOException, UnsupportedAudioFileException, LineUnavailableException{
		this.x = x;
		this.y = y;
		
		spaceShip = ImageIO.read(new File("res/Spaceship.png"));
		
		Renderer.addRenderableObject(this);
		Updater.addUpdateableObject(this);
	}
	
	@Override
	public double getWidth(){
		return width;
	}
	
	@Override
	public double getHeight(){
		return height;
	}
	
	@Override
	public double getX(){
		return x;
	}
	
	@Override
	public double getY(){
		return y;
	}
	
	@Override
	public int getLayer(){
		return layer;
	}
	
	@Override
	public BufferedImage getBufferedImage(){
		return spaceShip;
	}
	
	@Override
	public void update() throws IOException, UnsupportedAudioFileException, LineUnavailableException{
		if(Input.keys[Input.LEFT] && x >= 0)
			x -= speed * FPS.getDeltaTime();
		if(Input.keys[Input.RIGHT] && x <= Window.getWinWidth() - width)
			x += speed * FPS.getDeltaTime();
		if(Input.keys[Input.UP] && y >= 0)
			y -= speed * FPS.getDeltaTime();
		if(Input.keys[Input.DOWN] && y <= Window.getWinHeight() - height)
			y += speed * FPS.getDeltaTime();
		
		if(Input.keys[Input.SPACE] && timer.isRinging()) {
			new Bullet(x + (getWidth() / 2), y);
			timer.resetTimer();
			
			Sound.playSound("res/Shooting.wav");
		}

		
		Updateable collidingObject = isColliding(this, "enemyspaceship");
		if(collidingObject != null) {
			Renderer.removeRenderableObject(this);
			Updater.removeUpdateableObject(this);
			
			Renderer.removeRenderableObject(collidingObject.getRenderable());
			Updater.removeUpdateableObject(collidingObject);
			
			Sound.playSound("res/Death.wav");
		}
	}
	
	@Override
	public boolean drawCollisionBox() {
		return drawCollisionBox;
	}
	
	@Override
	public String getID() {
		return ID;
	}
	
	@Override
	public Renderable getRenderable() {
		return this;
	}
}