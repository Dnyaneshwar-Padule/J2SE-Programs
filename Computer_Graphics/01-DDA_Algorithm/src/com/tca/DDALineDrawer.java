package com.tca;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DDALineDrawer extends JPanel {

	private int x1;
	private int x2;
	private int y1;
	private int y2;
	
	public DDALineDrawer(int x1, int y1, int x2, int y2) {
	    this.x1 = x1;
	    this.y1 = y1;
	    this.x2 = x2;
	    this.y2 = y2;
	}

	private void drawLine(int x1, int y1, int x2, int y2, Graphics g) {
	    int dx = x2 - x1;
	    int dy = y2 - y1;
	    int steps = Math.max(Math.abs(dx), Math.abs(dy));

	    float xIncrement = (float) dx / steps;
	    float yIncrement = (float) dy / steps;

	    float x = x1;
	    float y = y1;

	    for (int i = 0; i <= steps; i++) {
	        g.fillRect(Math.round(x), Math.round(y), 1, 1);
	        x += xIncrement;
	        y += yIncrement;
	    }
	}

	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		drawLine(x1, y1, x2, y2, g);
	}
	
	
	
}
