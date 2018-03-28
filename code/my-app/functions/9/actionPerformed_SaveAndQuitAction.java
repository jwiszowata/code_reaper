public void actionPerformed(ActionEvent ae) {
    if (freeColClient.isMapEditor()) {
        freeColClient.getMapEditorController().saveMapEditorGame();
        freeColClient.quit();
    } else {
        if (!igc().saveAndQuit())
            return;
    }
}