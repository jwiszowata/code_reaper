public boolean csEquipForRole(Unit unit, Role role, int roleCount, Random random, ChangeSet cs) {
    boolean ret = equipForRole(unit, role, roleCount);
    if (ret) {
        if (unit.isOnCarrier())
            unit.setMovesLeft(0);
        Tile tile = getTile();
        tile.cacheUnseen();
        unit.setLocation(tile);
        cs.add(See.perhaps(), tile);
    }
    return ret;
}