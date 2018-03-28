public void removeNotify() {
    super.removeNotify();
    removeAll();
    toAmericaPanel = null;
    toEuropePanel = null;
    docksPanel = null;
    marketPanel = null;
    log = null;
    exitButton = trainButton = purchaseButton = recruitButton = unloadButton = sailButton = null;
}