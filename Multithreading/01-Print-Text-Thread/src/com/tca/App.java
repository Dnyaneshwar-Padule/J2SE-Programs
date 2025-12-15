package com.tca;

import com.tca.util.PrintTextThread;

public class App {

	public static void main(String[] args) {
		PrintTextThread p1 = new PrintTextThread("Dennis Ritchie", 5);
		PrintTextThread p2 = new PrintTextThread("James Gosling", 5);
	
		p1.start();
		p2.start();
	}

}
