public void actionPerformed(ActionEvent ae) {
    if (!freeColClient.isMapEditor()) {
        igc().loadGame();
    } else {
        freeColClient.getMapEditorController().loadGame();
    }
}