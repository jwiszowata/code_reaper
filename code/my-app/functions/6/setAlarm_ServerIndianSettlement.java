public void setAlarm(Player player, Tension newAlarm) {
    if (player != null && player != owner) {
        super.setAlarm(player, newAlarm);
        updateMostHated();
    }
}