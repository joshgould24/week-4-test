package djikstra_deadlock;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
	
	Semaphore leftChopstick;
	Semaphore rightChopstick;
	boolean hasLeftChopstick = false;
	boolean hasRightChopstick = false;
	
	String identifier;
	
	public Philosopher(Semaphore leftChopstick, Semaphore rightChopstick, String identifier) {
		super();
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
		this.identifier = identifier;
	}
	
	protected void think() {
		System.out.println("Philosopher " + identifier + " is thinking about morals or something...");
		try {
			sleep(new Random().nextInt(850) + 150);    //[0...84] + 15 = [15...99]
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Philosopher " + identifier + " is bored of thinking...");
	}
	
	protected void eat() {
		if(hasLeftChopstick && hasRightChopstick) {
			System.out.println("Philosopher " + identifier + " started eating...");
			try {
				sleep(new Random().nextInt(850) + 150);    //[0...84] + 15 = [15...99]
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Philosopher " + identifier + " finished eating...");
		}else {
			System.out.println("Philosopher " + identifier + " does not have enough chopsticks to eat...");
		}
		
		
	}

	protected void grab_right() {
		try {
			rightChopstick.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Philosopher " + identifier + " picked up their right chopstick");
		hasRightChopstick = true;
	}

	protected void grab_left() {
		try {
			leftChopstick.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Philosopher " + identifier + " picked up their left chopstick");
		hasLeftChopstick = true;
	}

	protected void release_right() {
		rightChopstick.release();
		System.out.println("Philosopher " + identifier + " dropped their right chopstick");
	}

	protected void release_left() {
		leftChopstick.release();
		System.out.println("Philosopher " + identifier + " dropped their left chopstick");
	}
}
