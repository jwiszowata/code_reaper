public void showInformationMessage(FreeColObject displayObject, StringTemplate template) {
    ImageIcon icon = null;
    Tile tile = null;
    if (displayObject != null) {
        icon = createObjectImageIcon(displayObject);
        tile = (displayObject instanceof Location) ? ((Location) displayObject).getTile() : null;
    }
    showInformationMessage(displayObject, tile, icon, template);
}