private void updateMapDisplayVariables() {
    topSpace = (size.height - tileHeight) / 2;
    if ((topSpace % (halfHeight)) != 0) {
        topRows = topSpace / (halfHeight) + 2;
    } else {
        topRows = topSpace / (halfHeight) + 1;
    }
    bottomRows = topRows;
    leftSpace = (size.width - tileWidth) / 2;
    rightSpace = leftSpace;
}