package render;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public interface Renderable extends Comparable<Object>{
	public int getLayer();
	public double getX();
	public double getY();
	public double getWidth();
	public double getHeight();
	public BufferedImage getBufferedImage();
	
	public default void drawSprite(Graphics2D g){
		g.drawImage(getBufferedImage(), (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
	}
	
	public default int compareTo(Object o){
		Renderable object = (Renderable)o;
		
		if(getLayer() < object.getLayer())
			return -1;
		else if(getLayer() > object.getLayer())
			return 1;
		else
			return 0;
	}
}
	