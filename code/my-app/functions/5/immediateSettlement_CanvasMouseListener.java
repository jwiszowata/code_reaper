private void immediateSettlement(Tile tile) {
    if (tile.hasSettlement()) {
        getFreeColClient().getGUI().showSettlement(tile.getSettlement());
    }
}