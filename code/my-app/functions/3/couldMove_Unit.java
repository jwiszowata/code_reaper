public boolean couldMove() {
    return readyAndAble() && getDestination() == null && getTradeRoute() == null;
}