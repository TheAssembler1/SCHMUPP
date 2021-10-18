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
	private static ArrayList<Renderable> addRenderableObjects = new ArrayList<Renderable>();
	private static ArrayList<Renderable> removeRenderableObjects = new ArrayList<Renderable>();
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		for(Renderable object: renderableObjects)
			object.drawSprite(g2d);
		
		renderableObjects.removeAll(removeRenderableObjects);
		if(addRenderableObjects.size() > 0){
			renderableObjects.addAll(addRenderableObjects);
			Collections.sort(renderableObjects);
		}
		
		addRenderableObjects.clear();
		removeRenderableObjects.clear();
	}
	
	public static void addRenderableObject(Renderable object){
		addRenderableObjects.add(object);
	}
	
	public static void removeRenderableObject(Renderable object){
		removeRenderableObjects.add(object);
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension((int)Window.getWinWidth(), (int)Window.getWinHeight());
	}
}
