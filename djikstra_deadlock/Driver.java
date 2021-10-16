package djikstra_deadlock;

import java.util.concurrent.Semaphore;

public class Driver {

	public static void main(String[] args) {
		
		////////////////
		///////A////////
		/////1///3//////
		////B//2///C////
		////////////////
		
		Semaphore chopstick1 = new Semaphore(1);
		Semaphore chopstick2 = new Semaphore(1);
		Semaphore chopstick3 = new Semaphore(1);
		
		PhilosopherA A = new PhilosopherA(chopstick3, chopstick1, "A");
		PhilosopherB B = new PhilosopherB(chopstick1, chopstick2, "B");
		PhilosopherC C = new PhilosopherC(chopstick2, chopstick3, "C");
		
		A.start();
		B.start();
		C.start();

	}

}
