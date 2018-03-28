public void removeAlarm(Player player) {
    if (player != null) {
        alarm.remove(player);
        updateMostHated();
    }
}