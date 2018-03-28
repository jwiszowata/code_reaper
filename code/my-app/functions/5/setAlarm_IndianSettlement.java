public void setAlarm(Player player, Tension newAlarm) {
    synchronized (this.alarm) {
        this.alarm.put(player, newAlarm);
    }
}