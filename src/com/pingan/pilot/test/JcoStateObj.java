package com.pingan.pilot.test;

import java.util.EventObject;

public class JcoStateObj extends EventObject {
	private String state;

	public JcoStateObj(Object source, String state) {
		super(source);
		// TODO Auto-generated constructor stub
		this.setState(state);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
