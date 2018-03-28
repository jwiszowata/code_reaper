int setOffsetFocus(Tile tile) {
    if (tile == null)
        return 0;
    int where;
    final Map map = getGame().getMap();
    final int tx = tile.getX(), ty = tile.getY(), width = rightColumn - leftColumn;
    int moveX = -1;
    gui.setFocus(tile);
    positionMap(tile);
    if (leftColumn <= 0) {
        if (tx <= width / 4) {
            where = -1;
        } else if (tx >= 3 * width / 4) {
            where = 1;
        } else {
            moveX = tx + width / 4;
            where = -1;
        }
    } else if (rightColumn >= width - 1) {
        if (tx >= rightColumn - width / 4) {
            where = 1;
        } else if (tx <= rightColumn - 3 * width / 4) {
            where = -1;
        } else {
            moveX = tx - width / 4;
            where = 1;
        }
    } else {
        moveX = tx - width / 4;
        where = 1;
    }
    if (moveX >= 0) {
        Tile other = map.getTile(moveX, ty);
        gui.setFocus(other);
        positionMap(other);
    }
    return where;
}