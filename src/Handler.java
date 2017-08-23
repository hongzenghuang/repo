
public class Handler implements Runnable, JacocoListener {
	private String name;
	public boolean isreset = false;
	public boolean isdump = false;
	
	public Handler(String name){this.name=name;}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while(true){
			if(this.isreset){
				this.isreset = false;
				reset();
			}
			if(this.isdump){
				this.isdump = false;
				dump();
			}
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		System.out.println("reset the jacocoagent status");
	}
	@Override
	public void dump() {
		// TODO Auto-generated method stub
		System.out.println("dump the file from jacocoagent");
	}

}
