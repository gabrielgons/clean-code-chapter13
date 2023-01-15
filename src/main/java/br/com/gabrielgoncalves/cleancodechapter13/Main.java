package br.com.gabrielgoncalves.cleancodechapter13;

public class Main {
	 private static int sharedCounter = 0;

	    public static void main(String[] args) throws InterruptedException {
	        Runnable task = () -> {
	            for (int i = 0; i < 1000; i++) {
	                incrementCounter();
	            }
	        };

	        Thread t1 = new Thread(task);
	        Thread t2 = new Thread(task);

	        t1.start();
	        t2.start();

	        t1.join();
	        t2.join();

	        System.out.println("Final value of sharedCounter: " + sharedCounter);
	    }

	    private static void incrementCounter() {
	        sharedCounter++;
	    }
}



