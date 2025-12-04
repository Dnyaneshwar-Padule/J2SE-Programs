package com.tca.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import com.tca.Server;

public class CommandExecutor implements Runnable{
	private PrintWriter out;

	public CommandExecutor(PrintWriter out) {
		this.out = out;
	}

	@Override
	public void run() {

		try {
			ProcessBuilder processBuilder = new ProcessBuilder();
			processBuilder.redirectErrorStream(true);
			Process process = null;

			while (!Thread.currentThread().isInterrupted()) {
				try {
					String cmd = Server.getNextCommand();
					if(cmd == null)
						continue;
					
					process = processBuilder.command("cmd", "/c", cmd).start();
					BufferedReader br = new BufferedReader( new InputStreamReader( process.getInputStream() ) );
					String line;
					while((line = br.readLine()) != null) {
						out.println("\033[95m" + line + "\033[0m");
					}
					br.close();
				}
				catch (Exception e) {
					out.println("\033[31m" + e.getMessage() + "\033[0m");							
				}
				
				out.println("======================Executed====================");
				
				TimeUnit.SECONDS.sleep(1);
				
			}
		} catch (InterruptedException e) {
			out.println("\033[31m" + e.getMessage() + "\033[0m");		
		} catch (Exception e) {
			e.printStackTrace();
			out.println("\033[31m" + e.getMessage() + "\033[0m");
		}
	}		
}
