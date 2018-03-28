private int getLeftColumns(int y) {
    int leftColumns = leftSpace / tileWidth + 1;
    if ((y & 1) == 0) {
        if ((leftSpace % tileWidth) > 32) {
            leftColumns++;
        }
    } else {
        if ((leftSpace % tileWidth) == 0) {
            leftColumns--;
        }
    }
    return leftColumns;
}