package task1;

import java.util.concurrent.Semaphore;

public class Driver {

	public static void main(String[] args) {
		
		Semaphore S = new Semaphore(1); //only allowing 1 thread to use the semaphore at a time allows for Mutual exclusion - the first condition for deadlock to occur.
		Semaphore R = new Semaphore(1);
		
		//2 processes have been made which can cause circular wait deadlock to occur if resources are not handled correctly.
		A processA = new A(S, R);
		B processB = new B(S, R);
		
		processA.start();
		processB.start();

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
