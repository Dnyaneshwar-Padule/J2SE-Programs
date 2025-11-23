package com.tca;

import javax.swing.JFrame;

public class App {

	public static void main(String[] args) {

		JFrame f = new JFrame("Bresenham's line drawing algorithm");
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.setVisible(true);
		f.setSize(800,800);
		f.add( new BresenhamsLineDrawer(100, 100, 500, 300) );
		
	}


}
