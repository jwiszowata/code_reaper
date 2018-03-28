boolean scrollMap(Direction direction) {
    Tile t = focus;
    if (t == null)
        return false;
    int fx = t.getX(), fy = t.getY();
    if ((t = t.getNeighbourOrNull(direction)) == null)
        return false;
    int tx = t.getX(), ty = t.getY();
    int x, y;
    if (isMapNearTop(ty) && isMapNearTop(fy)) {
        y = (ty <= fy) ? fy : topRows;
    } else if (isMapNearBottom(ty) && isMapNearBottom(fy)) {
        y = (ty >= fy) ? fy : getGame().getMap().getWidth() - bottomRows;
    } else {
        y = ty;
    }
    if (isMapNearLeft(tx, ty) && isMapNearLeft(fx, fy)) {
        x = (tx <= fx) ? fx : getLeftColumns(ty);
    } else if (isMapNearRight(tx, ty) && isMapNearRight(fx, fy)) {
        x = (tx >= fx) ? fx : getGame().getMap().getWidth() - getRightColumns(ty);
    } else {
        x = tx;
    }
    if (x == fx && y == fy)
        return false;
    gui.setFocus(getGame().getMap().getTile(x, y));
    return true;
}