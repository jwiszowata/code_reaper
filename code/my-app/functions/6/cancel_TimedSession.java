protected synchronized void cancel() {
    if (this.timer != null) {
        this.timer.cancel();
        this.timer = null;
    }
}