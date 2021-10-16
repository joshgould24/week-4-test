package djikstra_deadlock;

import java.util.concurrent.Semaphore;

public class PhilosopherC extends Philosopher {
	public PhilosopherC(Semaphore leftChopstick, Semaphore rightChopstick, String identifier) {
		super(leftChopstick, rightChopstick, identifier);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		 think();
	     grab_right();
	     grab_left();
	     eat();
	     release_right();
	     release_left();
	     think();
	}
}
