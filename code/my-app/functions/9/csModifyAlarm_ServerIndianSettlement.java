public boolean csModifyAlarm(Player player, int add, boolean propagate, ChangeSet cs) {
    Tile copied = getTile().getTileToCache();
    boolean change = csChangeAlarm(player, add, propagate, cs);
    if (change) {
        getTile().cacheUnseen(copied);
        cs.add(See.perhaps(), this);
    }
    return change;
}