public void actionPerformed(ActionEvent ae) {
    Dimension size = getGUI().showMapSizeDialog();
    if (size == null)
        return;
    final Game game = getGame();
    Map map = getFreeColClient().getFreeColServer().createEmptyMap(game, size.width, size.height);
    game.setMap(map);
    Tile tile = map.getTile(size.width / 2, size.height / 2);
    getGUI().setFocus(tile);
    getGUI().updateMenuBar();
    getGUI().refresh();
}