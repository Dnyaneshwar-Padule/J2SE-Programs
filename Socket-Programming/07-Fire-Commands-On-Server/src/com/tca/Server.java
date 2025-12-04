package com.tca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

import com.tca.util.CommandExecutor;

public class Server {
	
	private static Queue<String> commands = new LinkedList<String>();

	public static void main(String[] args) {
		
		
		ServerSocket server = null;
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			
			server = new ServerSocket(1024);
			System.out.println("\033[32mServer is listening on port 1024...\033[0m");
			System.out.println("\033[93mWaiting for client...\033[0m");
			
			socket = server.accept();
		
			System.out.println("\033[32mClient is connected : " + socket.getInetAddress() + "\033[0m");
			
			in = new BufferedReader(new InputStreamReader( socket.getInputStream() ));
			out = new PrintWriter(socket.getOutputStream(), true);
			
			out.println("\033[32mConnected to Server.\033[0m");		
			out.println("\033[31mReady to fire commands !\033[0m");
			out.println("\033[93mEnter 'STOP' to exit (disconnect).\033[0m");
			
			Thread commandExecutor = new Thread(new CommandExecutor(out));
			commandExecutor.start();
			
			String cmd;
			Process process = null;
			try {
				while(true) {
					cmd = in.readLine();
					
					if(cmd.equalsIgnoreCase("stop"))
						break;
					
					System.out.println("Command : " + cmd);
					
					commands.add(cmd);
				}
			}
			catch(Exception e) {
				out.println("\033[31m" + e.getMessage() + "\033[0m");
			}
			out.println("\033[31mDisconnecting..\033[0m");
			commandExecutor.interrupt();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(in != null)
					in.close();
				
				if(out!= null)
					out.close();
				
				if(socket!= null)
					socket.close();

				if(server != null)
					server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static synchronized String getNextCommand() { 
		if(commands != null && ! commands.isEmpty())
			return commands.poll();
		return null;
	}
	
}
