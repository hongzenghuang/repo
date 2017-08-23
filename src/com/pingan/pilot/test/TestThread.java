package com.pingan.pilot.test;

public class TestThread implements IJcoEventListener, Runnable {
	private boolean isreset = false;
	private boolean isdump = false;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		JcoEventListener list = new JcoEventListener();
		Test.manager2.addListener(list);
		while(true)
		{	
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			if(isreset){
				System.out.println(Thread.currentThread().getName() + "fire reset event from thread");
			}
			else if(isdump)
				System.out.println(Thread.currentThread().getName() + "fire dump event from thread");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void jcoStatehandler(JcoStateObj event) {
		// TODO Auto-generated method stub
		if(event.getState()!=null && event.getState().equals("reset"))
			this.isreset = true;
		else if (event.getState()!=null && event.getState().equals("dump"))
			this.isdump = true;
	}
}