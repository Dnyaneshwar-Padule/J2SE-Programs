package com.tca;

public class ChatUser extends Thread{

	private volatile boolean stopped = false;
	private volatile boolean suspended = false;
	
	public ChatUser(String msg){
		super(msg);
	}
	
	public void run(){
		try {
			
			for(int i = 0; i < 10; i++){
				
				synchronized (this) {
					while(suspended) {
						wait();
					}
					
					if(stopped) break;
				}
				
				System.out.println(getName() + " sending message " + i);
				Thread.sleep(500);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println(getName() + " was interrupted !");
		}
	}
	
	public void mySuspend() {
		suspended = true;
	}
	
	public void myStop() {
		stopped = true;
		this.interrupt();
	}
	
	public synchronized void myResume() {
		suspended = false;
		notify();
	}
	
	
	
}
