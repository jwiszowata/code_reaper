private void immediatePopup(Tile tile, int x, int y) {
    if (canvas.isGotoStarted())
        canvas.stopGoto();
    canvas.showTilePopup(tile, x, y);
}