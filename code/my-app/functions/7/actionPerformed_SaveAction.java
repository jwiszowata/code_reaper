public void actionPerformed(ActionEvent ae) {
    if (!freeColClient.isMapEditor()) {
        igc().saveGame();
    } else {
        freeColClient.getMapEditorController().saveMapEditorGame();
    }
}