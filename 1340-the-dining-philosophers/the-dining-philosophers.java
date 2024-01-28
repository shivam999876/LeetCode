class DiningPhilosophers {

    private Semaphore[] forks = new Semaphore[5];
	private Lock eaters;
	
	
	public DiningPhilosophers() {
        for(int i=0; i<5; i++) {
        	forks[i] = new Semaphore(1);
        }
        eaters = new ReentrantLock();
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
    	
    	eaters.lock();
    	forks[philosopher].acquire();
    	forks[(philosopher+1) %5].acquire();
    	
    	pickLeftFork.run();
    	pickRightFork.run();
    	
    	eat.run();
    	
    	putLeftFork.run();
    	putRightFork.run();
    	
    	forks[philosopher].release();
    	forks[(philosopher + 1) % 5].release();
    	eaters.unlock();
    	
    	
    }
}