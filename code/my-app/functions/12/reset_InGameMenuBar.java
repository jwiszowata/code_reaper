public final void reset() {
    removeAll();
    buildGameMenu();
    buildViewMenu();
    buildOrdersMenu();
    buildReportMenu();
    buildColopediaMenu();
    if (FreeColDebugger.isInDebugMode(FreeColDebugger.DebugMode.MENUS)) {
        add(new DebugMenu(freeColClient));
    }
    update();
}