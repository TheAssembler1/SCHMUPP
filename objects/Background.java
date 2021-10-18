package objects;

import update.Updateable;
import update.Updater;

import render.Renderable;
import render.Renderer;

import core.Window;
import core.FPS;

import java.awt.image.BufferedImage;

import java.io.IOException;
import java.io.File;

import javax.imageio.ImageIO;

public class Background implements Updateable, Renderable{
	private static double width = Window.getWinWidth();
	private static double height = Window.getWinHeight() * 2;
	private static double x = 0;
	private double y;
	
	private final int layer = 0;
	
	private static BufferedImage background;
	
	private double speed = 300;
	
	public Background(double y) throws IOException{
		this.y = y;
		
		background = ImageIO.read(new File("res/Space.png"));
		
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
		return background;
	}
	
	@Override
	public void update(){
		y += speed * FPS.getDeltaTime();
		
		if(y  >= 0)
			y = -Window.getWinHeight();
	}
}