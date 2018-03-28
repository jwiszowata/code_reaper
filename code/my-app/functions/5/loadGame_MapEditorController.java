public void loadGame() {
    File file = getGUI().showLoadSaveFileDialog();
    if (file != null)
        loadGame(file);
}