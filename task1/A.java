package task1;

import java.util.concurrent.Semaphore;

public class A extends Thread {
	
	Semaphore S;
	Semaphore R;
	
	protected A(Semaphore S, Semaphore R) {
		super();
		this.S = S;
		this.R = R;
	}

	@Override
	public synchronized void run() {
		System.out.println("A - Started");
		try {
			S.acquire();
			System.out.println("A - Acquired Resource S");
			R.acquire();
			System.out.println("A - Acquired Resource R");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("A - Got to the end");
//		try {
//			System.out.println("A - waiting...");
//			wait(2000);
//			System.out.println("A - done waiting!");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		S.release();
		System.out.println("A - Released Resource S");
		R.release();
		System.out.println("A - Released Resource R");
	}
}
