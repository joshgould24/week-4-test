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
	public synchronized void run() {
		System.out.println("B - Started");
		try {
			R.acquire();
			System.out.println("B - Acquired Resource R");
			S.acquire();
			System.out.println("B - Acquired Resource S");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("B - Got to the end");
//		try {
//			System.out.println("B - waiting...");
//			wait(2000);
//			System.out.println("B - done waiting!");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		S.release();
		System.out.println("B - Released Resource S");
		R.release();
		System.out.println("B - Released Resource R");
	}
}
