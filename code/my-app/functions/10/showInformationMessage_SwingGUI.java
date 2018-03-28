public void showInformationMessage(Unit displayObject, StringTemplate template) {
    super.showInformationMessage(displayObject, template);
    ImageIcon icon = null;
    Tile tile = null;
    if (displayObject != null) {
        icon = new ImageIcon(imageLibrary.getUnitImage(displayObject));
        tile = displayObject.getTile();
    }
    canvas.showInformationMessage(displayObject, tile, icon, template);
}