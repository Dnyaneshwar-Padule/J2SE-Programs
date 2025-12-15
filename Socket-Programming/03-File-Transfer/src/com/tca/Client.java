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
			
			System.out.print("Enter name of the file : ");
			String fileName = br.readLine();
			outputStream.writeUTF( fileName );
			System.out.println("Requested : " + fileName);
			
			try(FileOutputStream out = new FileOutputStream(fileName)) {
				byte buffer[] = new byte[8192];
				int bytesRead;
				
				while( (bytesRead = inputStream.read(buffer)) != -1 ) {
					out.write(buffer, 0, bytesRead);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("File is received !");
			socket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
