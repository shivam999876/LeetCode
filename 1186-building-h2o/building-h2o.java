class H2O {
    private int turn = 0;

    public H2O() {
    }

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (turn == 2) {
            wait();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        turn++;
        notifyAll();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (turn < 2) {
            wait();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        turn = 0;
        notifyAll();
    }
}
