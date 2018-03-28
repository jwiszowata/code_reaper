public void newMap() {
    final Game game = getGame();
    getGUI().removeInGameComponents();
    OptionGroup mgo = getGUI().showMapGeneratorOptionsDialog(true);
    if (mgo == null)
        return;
    game.setMapGeneratorOptions(mgo);
    getFreeColServer().getMapGenerator().createMap(new LogBuilder(-1));
    requireNativeNations(game);
    getGUI().setFocus(game.getMap().getTile(1, 1));
    getGUI().updateMenuBar();
    getGUI().refresh();
}