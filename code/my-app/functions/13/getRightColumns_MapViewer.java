private int getRightColumns(int y) {
    int rightColumns = rightSpace / tileWidth + 1;
    if ((y & 1) == 0) {
        if ((rightSpace % tileWidth) == 0) {
            rightColumns--;
        }
    } else {
        if ((rightSpace % tileWidth) > 32) {
            rightColumns++;
        }
    }
    return rightColumns;
}