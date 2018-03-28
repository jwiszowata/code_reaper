public void saveMapEditorGame() {
    File file = getGUI().showSaveDialog(FreeColDirectories.getSaveDirectory(), FreeColDirectories.MAP_FILE_NAME);
    if (file != null)
        saveMapEditorGame(file);
}