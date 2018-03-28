public boolean carriableBy(Unit carrier) {
    return carrier.couldCarry(getGoods());
}