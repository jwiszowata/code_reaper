public void removeNotify() {
    if (colony == null)
        return;
    colony.setOccupationTrace(false);
    colony = null;
    super.removeNotify();
    unloadButton = null;
    fillButton = null;
    warehouseButton = null;
    buildQueueButton = null;
    colonyUnitsButton = null;
    setGoodsButton = null;
    traceWorkButton = null;
    netProductionPanel = null;
    buildingsPanel = null;
    buildingsScroll = null;
    cargoScroll = null;
    constructionPanel = null;
    inPortScroll = null;
    outsideColonyPanel = null;
    outsideColonyScroll = null;
    populationPanel = null;
    tilesPanel = null;
    tilesScroll = null;
    warehousePanel = null;
    warehouseScroll = null;
    releaseListener = null;
}