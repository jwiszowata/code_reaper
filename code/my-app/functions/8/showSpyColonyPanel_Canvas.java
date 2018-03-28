public ColonyPanel showSpyColonyPanel(Tile tile) {
    Colony colony = tile.getColony();
    if (colony == null)
        return null;
    ColonyPanel panel = new ColonyPanel(freeColClient, colony);
    showFreeColPanel(panel, tile, true);
    return panel;
}