private void positionMap(Tile pos) {
    final Game game = getGame();
    int x = pos.getX(), y = pos.getY();
    int leftColumns = getLeftColumns(), rightColumns = getRightColumns();
    alignedTop = false;
    alignedBottom = false;
    if (y < topRows) {
        alignedTop = true;
        bottomRow = (size.height / (halfHeight)) - 1;
        if ((size.height % (halfHeight)) != 0) {
            bottomRow++;
        }
        topRow = 0;
        bottomRowY = bottomRow * (halfHeight);
        topRowY = 0;
    } else if (y >= (game.getMap().getHeight() - bottomRows)) {
        alignedBottom = true;
        bottomRow = game.getMap().getHeight() - 1;
        topRow = size.height / (halfHeight);
        if ((size.height % (halfHeight)) > 0) {
            topRow++;
        }
        topRow = game.getMap().getHeight() - topRow;
        bottomRowY = size.height - tileHeight;
        topRowY = bottomRowY - (bottomRow - topRow) * (halfHeight);
    } else {
        bottomRow = y + bottomRows - 1;
        topRow = y - topRows;
        bottomRowY = topSpace + (halfHeight) * bottomRows;
        topRowY = topSpace - topRows * (halfHeight);
    }
    alignedLeft = false;
    alignedRight = false;
    if (x < leftColumns) {
        leftColumn = 0;
        rightColumn = size.width / tileWidth - 1;
        if ((size.width % tileWidth) > 0) {
            rightColumn++;
        }
        leftColumnX = 0;
        alignedLeft = true;
    } else if (x >= (game.getMap().getWidth() - rightColumns)) {
        rightColumn = game.getMap().getWidth() - 1;
        leftColumn = size.width / tileWidth;
        if ((size.width % tileWidth) > 0) {
            leftColumn++;
        }
        leftColumnX = size.width - tileWidth - halfWidth - leftColumn * tileWidth;
        leftColumn = rightColumn - leftColumn;
        alignedRight = true;
    } else {
        leftColumn = x - leftColumns;
        rightColumn = x + rightColumns;
        leftColumnX = (size.width - tileWidth) / 2 - leftColumns * tileWidth;
    }
}