public boolean remove(Locatable locatable) {
    if (locatable == null) {
        throw new IllegalArgumentException("Locatable must not be 'null'.");
    } else if (locatable instanceof Unit && canCarryUnits()) {
        if (super.remove(locatable)) {
            spendAllMoves();
            return true;
        }
    } else if (locatable instanceof Goods && canCarryGoods()) {
        if (super.removeGoods((Goods) locatable) != null) {
            spendAllMoves();
            return true;
        }
    } else {
        logger.warning("Tried to remove from unit: " + locatable);
    }
    return false;
}