private void createTileMenu(final ASingleTilePanel singleTilePanel) {
    if (singleTilePanel.getColonyTile() != null && singleTilePanel.getColonyTile().getColony() != null) {
        addTileItem(singleTilePanel.getColonyTile().getWorkTile());
    }
}