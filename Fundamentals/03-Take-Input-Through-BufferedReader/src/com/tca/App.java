package com.tca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) throws IOException, NumberFormatException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		int num;
		
		System.out.print("Enter a number : ");
		num = Integer.parseInt(br.readLine());
		
		System.out.println("Entered number : " + num);
		
		br.close();
	}

}
