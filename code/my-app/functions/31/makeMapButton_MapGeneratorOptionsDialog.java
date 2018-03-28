private JButton makeMapButton(File file) {
    final String mapName = file.getName().substring(0, file.getName().lastIndexOf('.'));
    JButton mapButton = null;
    FreeColSavegameFile savegame;
    try {
        savegame = new FreeColSavegameFile(file);
    } catch (IOException ioe) {
        logger.log(Level.WARNING, "Failed to make save game for: " + mapName, ioe);
        return null;
    }
    Image thumbnail;
    try {
        thumbnail = ImageIO.read(savegame.getThumbnailInputStream());
    } catch (IOException ioe) {
        logger.log(Level.WARNING, "Failed to read thumbnail for: " + mapName, ioe);
        thumbnail = null;
    }
    if (thumbnail != null) {
        mapButton = Utility.localizedButton("freecol.map." + mapName);
        mapButton.setIcon(new ImageIcon(thumbnail));
        mapButton.setHorizontalTextPosition(JButton.CENTER);
        mapButton.setVerticalTextPosition(JButton.BOTTOM);
        try {
            Properties properties = savegame.getProperties();
            mapButton.setToolTipText(properties.getProperty("map.width") + "×" + properties.getProperty("map.height"));
        } catch (IOException ioe) {
            logger.log(Level.WARNING, "Failed to read properties for: " + mapName, ioe);
        }
    }
    return mapButton;
}