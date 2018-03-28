public boolean setVisited(Player player) {
    if (!hasVisited(player)) {
        if (!hasContacted(player))
            initializeAlarm(player);
        contactLevels.put(player, ContactLevel.VISITED);
        return true;
    }
    return false;
}