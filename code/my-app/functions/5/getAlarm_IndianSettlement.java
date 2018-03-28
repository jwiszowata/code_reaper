public Tension getAlarm(Player player) {
    synchronized (this.alarm) {
        return this.alarm.get(player);
    }
}