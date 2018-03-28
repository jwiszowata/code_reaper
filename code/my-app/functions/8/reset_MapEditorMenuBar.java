public final void reset() {
    removeAll();
    buildGameMenu();
    buildViewMenu();
    buildToolsMenu();
    buildColopediaMenu();
    update();
}