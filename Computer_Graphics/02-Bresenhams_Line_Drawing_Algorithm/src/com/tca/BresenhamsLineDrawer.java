package com.tca;

import java.awt.Graphics;

import javax.swing.JPanel;

public class BresenhamsLineDrawer extends JPanel {

	private int x1, x2, y1, y2;

	public BresenhamsLineDrawer(int x1, int x2, int y1, int y2) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawLine(x1, y1, x2, y2, g);
	}
	
	private void drawLine(int x1, int y1, int x2, int y2, Graphics g) {
		int dx = Math.abs( x2 - x1 );
		int dy = Math.abs( y2 - y1 );
		int p = 2*dy - dx;
		int x = x1, y = y1;
		
		for(; x <= x2; x++) {
			g.fillRect(x, y, 1, 1);
			
			if(p < 0) {
				p = p + 2 * dy;
			}
			else
			{
				y++;
				p = p + (2*dy - 2*dx);
			}
		}
		
	}
	
}
