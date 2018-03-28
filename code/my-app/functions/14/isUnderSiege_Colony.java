public boolean isUnderSiege() {
    int friendlyUnits = 0;
    int enemyUnits = 0;
    for (Unit u : iterable(flatten(getColonyTiles(), ct -> ct.getWorkTile().getUnits()))) {
        if (u.getOwner() == getOwner()) {
            if (u.isDefensiveUnit())
                friendlyUnits++;
        } else if (getOwner().atWarWith(u.getOwner())) {
            if (u.isOffensiveUnit())
                enemyUnits++;
        }
    }
    return enemyUnits > friendlyUnits;
}