public boolean add(Locatable locatable) {
    if (!canAdd(locatable)) {
        return false;
    } else if (locatable instanceof Unit) {
        Unit unit = (Unit) locatable;
        if (super.add(locatable)) {
            spendAllMoves();
            unit.setState(UnitState.SENTRY);
            return true;
        }
    } else if (locatable instanceof Goods) {
        Goods goods = (Goods) locatable;
        if (super.addGoods(goods)) {
            spendAllMoves();
            return true;
        }
    } else {
        throw new IllegalStateException("Can not be added to unit: " + locatable);
    }
    return false;
}