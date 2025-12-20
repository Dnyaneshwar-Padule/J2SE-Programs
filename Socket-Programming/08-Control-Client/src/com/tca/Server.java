package com.tca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.tca.listener.MouseEventListener;
import com.tca.util.ActionType;
import com.tca.util.ClientHandlerThread;


/*
 	1.It will give commands to the client [COMMAND]
 	2.It will give mouse events
 		like
 			MOUSE:MOVED:X:Y
 			MOUSE:CLICKED:RIGHT/LEFT
 			MOUSE:SCROLLED:UP/DOWN:VALUE
 	3.In future, I can also send keyboard events
 	
 	Client will mimic these mouse events, and execute given commands
 	
 	main thread will send the commands
 	I will create another thread, which will handle mouse events 
	
 */

public class Server{

	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket socket = null;
	
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			server = new ServerSocket(1024);
			System.out.println("\033[32mServer is started...\033[0m");
	
			socket  = server.accept();
			System.out.println("\033[32mClient is connected ...!\033[0m");
		
			//Now start a thread, which will handle client 
			//i.e that thread will accept the client response
			ClientHandlerThread clientHandler = new ClientHandlerThread(socket);
			clientHandler.start();
		
			
			//Now, the main thread will send instructions to the Client
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //auto flush
			String command;
			
			MouseEventListener mouseListener = new MouseEventListener(out);
			mouseListener.startListening();
			
			while(true) {
				System.out.print("\033[31mEnter the command : \033[0m");
				command = br.readLine();
				out.println(ActionType.COMMAND + ":" + command); // send command to client
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
				try {
					if(socket != null)
						socket.close();
					
					if(server != null)
						server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

	

}
