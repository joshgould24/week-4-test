package task1;

import java.util.concurrent.Semaphore;

public class Driver {

	public static void main(String[] args) {
		
		Semaphore S = new Semaphore(1);
		Semaphore R = new Semaphore(1);
		
		A processA = new A(S, R);
		B processB = new B(S, R);
		
		//processA.giveResource(S);
		processA.start();
		processB.start();
//		processA.run();
//		processB.run();
		System.out.println("both processes run");
		
		try {
			processA.join();
			processB.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Both processes joined");
		
	}

}
