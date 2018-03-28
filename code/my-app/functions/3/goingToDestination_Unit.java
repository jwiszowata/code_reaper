public boolean goingToDestination() {
    return readyAndAble() && getTradeRoute() == null && getDestination() != null;
}