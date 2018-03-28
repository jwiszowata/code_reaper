private void clearAlarm() {
    synchronized (this.alarm) {
        this.alarm.clear();
    }
}