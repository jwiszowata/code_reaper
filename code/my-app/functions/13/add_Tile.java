public boolean add(Locatable locatable) {
    if (locatable instanceof TileItem) {
        return addTileItem((TileItem) locatable);
    } else if (locatable instanceof Unit) {
        if (super.add(locatable)) {
            ((Unit) locatable).setState(Unit.UnitState.ACTIVE);
            return true;
        }
        return false;
    } else {
        return super.add(locatable);
    }
}