private void cleanup() {
    unloadButton.removeActionListener(unloadCmd);
    fillButton.removeActionListener(fillCmd);
    warehouseButton.removeActionListener(warehouseCmd);
    buildQueueButton.removeActionListener(buildQueueCmd);
    colonyUnitsButton.removeActionListener(colonyUnitsCmd);
    if (setGoodsButton != null) {
        setGoodsButton.removeActionListener(setGoodsCmd);
    }
    if (traceWorkButton != null) {
        traceWorkButton.removeActionListener(occupationCmd);
    }
    removePropertyChangeListeners();
    if (getSelectedUnit() != null) {
        getSelectedUnit().removePropertyChangeListener(this);
    }
    removeMouseListeners();
    for (MouseListener listener : getMouseListeners()) {
        removeMouseListener(listener);
    }
    setTransferHandlers(false);
    buildingsPanel.cleanup();
    cargoPanel.cleanup();
    constructionPanel.cleanup();
    inPortPanel.cleanup();
    outsideColonyPanel.cleanup();
    populationPanel.cleanup();
    tilesPanel.cleanup();
    warehousePanel.cleanup();
    removeAll();
}