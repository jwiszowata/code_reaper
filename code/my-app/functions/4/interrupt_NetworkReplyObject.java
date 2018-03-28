public synchronized void interrupt() {
    responseGiven = true;
    notify();
}