public boolean setContacted(Player player) {
    if (!hasContacted(player)) {
        contactLevels.put(player, ContactLevel.CONTACTED);
        initializeAlarm(player);
        return true;
    }
    return false;
}