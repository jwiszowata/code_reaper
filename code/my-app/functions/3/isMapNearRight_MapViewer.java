private boolean isMapNearRight(int x, int y) {
    return x >= getGame().getMap().getWidth() - getRightColumns(y);
}