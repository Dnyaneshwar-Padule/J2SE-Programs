package com.tca;

import javax.swing.JFrame;

public class App {

	public static void main(String[] args) {

		JFrame frame = new JFrame("DDA Line Drawing Algorithm");
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new DDALineDrawer(50, 100, 50, 500));
		frame.setVisible(true);
	}

}
