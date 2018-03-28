private void scroll(int x, int y, int scrollSpace, boolean ignoreTop) {
    Direction direction;
    Dimension size = canvas.getSize();
    if (x < scrollSpace && y < scrollSpace) {
        direction = !ignoreTop ? Direction.NW : Direction.W;
    } else if (x >= size.width - scrollSpace && y < scrollSpace) {
        direction = !ignoreTop ? Direction.NE : Direction.E;
    } else if (x >= size.width - scrollSpace && y >= size.height - scrollSpace) {
        direction = Direction.SE;
    } else if (x < scrollSpace && y >= size.height - scrollSpace) {
        direction = Direction.SW;
    } else if (y < scrollSpace) {
        direction = !ignoreTop ? Direction.N : null;
    } else if (x >= size.width - scrollSpace) {
        direction = Direction.E;
    } else if (y >= size.height - scrollSpace) {
        direction = Direction.S;
    } else if (x < scrollSpace) {
        direction = Direction.W;
    } else {
        direction = null;
    }
    if (direction == null) {
        stopScrollIfScrollIsActive();
    } else if (scrollThread == null || scrollThread.isInterrupted()) {
        scrollThread = new ScrollThread(canvas);
        scrollThread.setDirection(direction);
        scrollThread.start();
    } else {
        scrollThread.setDirection(direction);
    }
}