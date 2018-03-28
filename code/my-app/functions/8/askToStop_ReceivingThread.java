public synchronized void askToStop() {
    if (this.shouldRun) {
        this.shouldRun = false;
        for (NetworkReplyObject o : this.waitingThreads.values()) {
            o.interrupt();
        }
    }
}