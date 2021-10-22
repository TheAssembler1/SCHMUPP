package objects;

import update.Updateable;
import update.Updater;

import render.Renderable;
import render.Renderer;

import core.Window;
import core.FPS;

import java.awt.image.BufferedImage;

import java.io.IOException;
import java.util.Random;
import java.io.File;

import javax.imageio.ImageIO;

public class EnemySpaceship implements Updateable, Renderable{
	private double width;
	private double height;
	private double x;
	private double y;
	
	private final int layer = 2;
	
	private static BufferedImage enemySpaceShip;
	
	private double speed = 150;
	
	public int randDimensionsMax = 75;
	public int randDimensionsMin = 35;
	
	Random rand = new Random();
	
	private boolean drawCollisionBox = true;
	
	private static final String ID = "enemyspaceship";
	
	public EnemySpaceship() throws IOException{
		int dimensions = rand.nextInt(randDimensionsMax + 1);
		
		if(dimensions < randDimensionsMin)
			dimensions = randDimensionsMin;
		
		width = dimensions;
		height = dimensions;
		
		int posX = rand.nextInt((int)Window.getWinWidth() - (int)getWidth() + 1);
		this.x = posX;
		
		this.y = -getHeight();
		
		enemySpaceShip = ImageIO.read(new File("res/Enemy.png"));
		
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
		return enemySpaceShip;
	}
	
	@Override
	public void update() throws IOException{
		y += speed * FPS.getDeltaTime();
		
		if(y  >= Window.getWinHeight()) {
			Updater.removeUpdateableObject(this);
			Renderer.removeRenderableObject(this);
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