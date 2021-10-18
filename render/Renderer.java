package render;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

import core.Window;

public class Renderer extends JPanel{
	private static ArrayList<Renderable> renderableObjects = new ArrayList<Renderable>();
	
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		for(Renderable object: renderableObjects)
			object.draw(g2d);
	}
	
	public static void addRenderableObject(Renderable object){
		renderableObjects.add(object);
		Collections.sort(renderableObjects);
	}
	
	public static void removeRenderableObject(Renderable object){
		renderableObjects.remove(object);
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension((int)Window.getWinWidth() + 1, (int)Window.getWinHeight() + 1);
	}
}
