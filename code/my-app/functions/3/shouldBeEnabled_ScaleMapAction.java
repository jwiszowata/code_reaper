protected boolean shouldBeEnabled() {
    return super.shouldBeEnabled() && freeColClient.isMapEditor() && getGame() != null && getGame().getMap() != null;
}