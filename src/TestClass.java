import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


public class TestClass {
	static private boolean isreset = false;
	
	public void setIsReset(boolean isreset)
	{this.isreset = isreset;}
	
	class Test implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				if (isreset == true){
				System.out.println(Thread.currentThread().getName() + "set the jacoco env............");}
				else
				{System.out.println(Thread.currentThread().getName() + "don't need to reset env......");}
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		
	}

	public static void main(String[] args) throws IOException{
		Collection tests = new HashSet();
		
		for (int i = 0; i<2; i++)
		{
			TestClass tc = new TestClass();
			Test t = tc.new Test();
			Thread th = new Thread(t);
			tests.add(th);
		}
		
		Iterator itr = tests.iterator();
		while (itr.hasNext()){
			Thread t = (Thread)itr.next();
			t.start();
		}
		while (true)
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.print("Enter String");
	        String cmd = br.readLine();
	        
		if (cmd.toString().equals("reset"))
			isreset = true;
		else if(cmd.toString().equals("unreset"))
			isreset = false;
		else if(cmd.toString().equals("exit"))
			break;
		}
		
		/*
		Handler handler = new Handler("t1");
		Thread t1 = new Thread(handler);

		Handler handler2 = new Handler("t2");
		Thread t2 = new Thread(handler2);
		
		t1.start();
		t2.start();
		*/
/*		
		while(true){
			String cmd = System.console().readLine();
			if (cmd=="exit"){
				break;
			}
			else if(cmd == "reset"){
				firenotifyresetevent();
			}
		}
	}
	*/
}
}
