package render;

import java.awt.Dimension;

import javax.swing.JPanel;

import core.Window;

public class Renderer extends JPanel{
	@Override
	public Dimension getPreferredSize(){
		return new Dimension((int)Window.getWinWidth() + 1, (int)Window.getWinHeight() + 1);
	}
}
