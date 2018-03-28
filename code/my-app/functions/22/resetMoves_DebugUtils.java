public static void resetMoves(final FreeColClient freeColClient, List<Unit> units) {
    final FreeColServer server = freeColClient.getFreeColServer();
    final Game sGame = server.getGame();
    final GUI gui = freeColClient.getGUI();
    boolean first = true;
    for (Unit u : units) {
        Unit su = sGame.getFreeColGameObject(u.getId(), Unit.class);
        u.setMovesLeft(u.getInitialMovesLeft());
        su.setMovesLeft(su.getInitialMovesLeft());
        if (first) {
            gui.setActiveUnit(u);
            first = false;
        }
        for (Unit u2 : u.getUnitList()) {
            Unit su2 = sGame.getFreeColGameObject(u2.getId(), Unit.class);
            u2.setMovesLeft(u2.getInitialMovesLeft());
            su2.setMovesLeft(su2.getInitialMovesLeft());
        }
    }
    gui.refresh();
    gui.resetMenuBar();
}