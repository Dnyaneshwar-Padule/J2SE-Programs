package com.tca;

import java.net.URL;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		try {
			
			URL url = new URL("https://example.com");
			Scanner in = new Scanner(url.openStream());
			
			String str = in.nextLine();
			System.out.println(str);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}

}
