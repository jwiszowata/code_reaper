public void actionPerformed(ActionEvent ae) {
    File lastSave = FreeColDirectories.getLastSaveGameFile();
    if (lastSave != null) {
        if (getConnectController().startSavedGame(lastSave)) {
            getGUI().removeInGameComponents();
        } else {
            getGUI().showMainPanel(null);
        }
    }
}