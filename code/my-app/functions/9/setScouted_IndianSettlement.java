public boolean setScouted(Player player) {
    if (!hasScouted(player)) {
        if (!hasContacted(player))
            initializeAlarm(player);
        contactLevels.put(player, ContactLevel.SCOUTED);
        return true;
    }
    return false;
}