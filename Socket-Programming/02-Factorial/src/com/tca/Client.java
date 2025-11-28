package com.tca;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {

		Socket socket = null;
		DataInputStream inputStream;
		DataOutputStream outputStream;
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			
			socket = new Socket("localhost", 1024);
			System.out.println("Connected to server !");
			
			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());
			
			System.out.print("Enter the number : ");
			outputStream.writeUTF( br.readLine() );
			System.out.println("Factorial : " + inputStream.readUTF());
			
			socket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
