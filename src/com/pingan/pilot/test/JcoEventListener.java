package com.pingan.pilot.test;

import java.util.EventListener;

public class JcoEventListener implements IJcoEventListener {
	public void jcoStatehandler(JcoStateObj event){
		if(event.getState().equals("reset") && event.getState()!=null)
			System.out.println("trigger the reset event");
		if(event.getState().equals("dump") && event.getState()!=null)
			System.out.println("trigger the dump event");
			
	}
}
