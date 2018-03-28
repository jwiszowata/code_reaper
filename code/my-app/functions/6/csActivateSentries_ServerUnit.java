private void csActivateSentries(Tile tile, ChangeSet cs) {
    for (Unit u : transform(tile.getUnits(), matchKey(UnitState.SENTRY, Unit::getState))) {
        u.setState(UnitState.ACTIVE);
        cs.add(See.perhaps(), u);
    }
}