private boolean changeAlarm(Player player, int amount) {
    Tension alarm = getAlarm(player);
    if (alarm == null) {
        initializeAlarm(player);
        alarm = getAlarm(player);
    }
    Tension.Level oldLevel = alarm.getLevel();
    alarm.modify(amount);
    boolean change = updateMostHated();
    return change || oldLevel != alarm.getLevel();
}