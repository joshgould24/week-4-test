package task1;

import java.util.concurrent.Semaphore;

public class B extends Thread {

	Semaphore S;
	Semaphore R;
	
	protected B(Semaphore S, Semaphore R) {
		super();
		this.S = S;
		this.R = R;
	}

	@Override
	public void run() {
		System.out.println("B - Started");
		try {
			R.acquire();
			System.out.println("B - Acquired Resource R");
			
			S.acquire();
			System.out.println("B - Acquired Resource S");
			//hold and wait - this process has been allowed to hold resource R while waiting to acquire resource S.
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("B - Got to the end");
		
		S.release();
		System.out.println("B - Released Resource S");
		R.release();
		System.out.println("B - Released Resource R");
	}
}
