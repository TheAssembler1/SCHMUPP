package objects;

import update.Updateable;
import update.Updater;

import render.Renderable;
import render.Renderer;

import core.Window;
import core.FPS;
import core.Sound;

import java.awt.image.BufferedImage;

import java.io.IOException;
import java.io.File;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Bullet implements Updateable, Renderable{
	private static double width = 10;
	private static double height = 30;
	private double x;
	private double y;
	
	private final int layer = 1;
	
	private static BufferedImage bullet;
	
	private static double speed = 1000;
	
	private boolean drawCollisionBox = true;
	
	private static final String ID = "bullet";
	
	public Bullet(double x, double y) throws IOException{
		this.x = x - (getWidth() / 2);
		this.y = y + (getHeight() / 2);
		
		bullet = ImageIO.read(new File("res/Bullet.png"));
		
		Renderer.addRenderableObject(this);
		Updater.addUpdateableObject(this);
	}
	
	@Override
	public int getLayer(){
		return layer;
	};
	
	@Override
	public double getX(){
		return x;
	}
	
	@Override
	public double getY(){
		return y;
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
	public BufferedImage getBufferedImage(){
		return bullet;
	}
	
	@Override
	public void update() throws IOException, UnsupportedAudioFileException, LineUnavailableException{
		y -= speed * FPS.getDeltaTime();
		
		if(y < -getHeight()) {
			Updater.removeUpdateableObject(this);
			Renderer.removeRenderableObject(this);
		}
		
		Updateable collidingObject = isColliding(this, "enemyspaceship");
		if(collidingObject != null) {
			Renderer.removeRenderableObject(this);
			Updater.removeUpdateableObject(this);
			
			Renderer.removeRenderableObject(collidingObject.getRenderable());
			Updater.removeUpdateableObject(collidingObject);
			
			Sound.playSound("res/EnemyDeath.wav");
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