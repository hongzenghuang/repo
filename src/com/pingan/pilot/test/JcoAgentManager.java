package com.pingan.pilot.test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class JcoAgentManager {
	private Collection listeners;
	
	public void addListener(IJcoEventListener listener){
		if(listeners == null)
				listeners = new HashSet();
		listeners.add(listener);
	}

	protected void fireresetevent(){
		if (listeners == null)
			return;
		JcoStateObj event = new JcoStateObj(this, "reset");
		notifyListeners(event);
		
	}
	
	protected void firedumpevent(){
		if (listeners == null)
			return;
		JcoStateObj event = new JcoStateObj(this, "dump");
		notifyListeners(event);
		
	}

	private void notifyListeners(JcoStateObj event) {
		// TODO Auto-generated method stub
		Iterator<IJcoEventListener> itr = listeners.iterator();
		while(itr.hasNext())
		{
			IJcoEventListener listener = (IJcoEventListener)itr.next();
			listener.jcoStatehandler(event);
		}
	}
}
