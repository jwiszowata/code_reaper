public void startMapEditor() {
    final FreeColClient fcc = getFreeColClient();
    try {
        Specification specification = getDefaultSpecification();
        fcc.setMapEditor(true);
        final FreeColServer freeColServer = new FreeColServer(false, false, specification, 0, null);
        fcc.setFreeColServer(freeColServer);
        Game game = freeColServer.getGame();
        requireNativeNations(game);
        fcc.setGame(game);
        fcc.setMyPlayer(null);
        getSoundController().playSound(null);
        getGUI().closeMainPanel();
        getGUI().closeMenus();
        getGUI().changeViewMode(GUI.VIEW_TERRAIN_MODE);
        getGUI().startMapEditorGUI();
    } catch (IOException e) {
        getGUI().showErrorMessage(StringTemplate.template("server.initialize"));
        return;
    }
}