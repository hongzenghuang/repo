package com.pingan.pilot.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	
	public static JcoAgentManager manager2 = new JcoAgentManager();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		JcoAgentManager manager = new JcoAgentManager();
		manager.addListener(new JcoEventListener());
		
		
		TestThread t = new TestThread();
		manager.addListener(t);
		
		for(int i =0;i<10;i++){

			Thread thread = new Thread(t);
			thread.start();
		}
		System.out.println("start the app**************");
		
		
		while (true)
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.print("Enter String");
	        String cmd = br.readLine();
	        
		if (cmd.toString().equals("reset"))
			manager2.fireresetevent();
		else if(cmd.toString().equals("dump"))
			manager2.firedumpevent();
		else if(cmd.toString().equals("exit"))
			break;
		}
	}

}
