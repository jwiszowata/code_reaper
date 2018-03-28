public void actionPerformed(ActionEvent ae) {
    if (!freeColClient.isMapEditor())
        return;
    File startFile = FreeColDirectories.getStartMapFile();
    freeColClient.getMapEditorController().saveMapEditorGame(startFile);
    Game game = freeColClient.getGame();
    OptionGroup options = game.getMapGeneratorOptions();
    FileOption fileOption = (FileOption) options.getOption(MapGeneratorOptions.IMPORT_FILE);
    fileOption.setValue(startFile);
    File mapOptionsFile = FreeColDirectories.getOptionsFile(FreeColDirectories.MAP_GENERATOR_OPTIONS_FILE_NAME);
    options.save(mapOptionsFile, null, true);
    freeColClient.getGUI().removeInGameComponents();
    freeColClient.getGUI().showNewPanel(game.getSpecification());
}