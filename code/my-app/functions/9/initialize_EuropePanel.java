private void initialize(Europe europe) {
    toAmericaPanel.initialize(europe.getGame().getMap());
    toEuropePanel.initialize(europe);
    cargoPanel.initialize();
    inPortPanel.initialize();
    marketPanel.initialize();
    docksPanel.initialize();
    log.initialize();
}