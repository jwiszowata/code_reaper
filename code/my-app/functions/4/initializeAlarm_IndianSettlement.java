protected void initializeAlarm(Player player) {
    Tension tension = owner.getTension(player);
    setAlarm(player, new Tension(tension.getValue()));
}