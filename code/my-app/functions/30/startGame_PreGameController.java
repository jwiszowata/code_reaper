public boolean startGame() {
    final FreeColClient fcc = getFreeColClient();
    final Player player = getMyPlayer();
    final GUI gui = getGUI();
    gui.closeMainPanel();
    gui.closeMenus();
    gui.closeStatusPanel();
    getSoundController().playSound(null);
    getSoundController().playSound("sound.intro." + player.getNationId());
    fcc.changeClientState(true);
    gui.initializeInGame();
    final ClientOptions co = getClientOptions();
    if (player.isAdmin() && co.getBoolean(ClientOptions.AUTOSAVE_DELETE)) {
        String logMe = FreeColDirectories.removeAutosaves(co.getText(ClientOptions.AUTO_SAVE_PREFIX));
        if (logMe != null)
            logger.info(logMe);
    }
    final Game game = getGame();
    fcc.restoreGUI(player);
    game.setInitialActiveUnitId(null);
    if (FreeColDebugger.isInDebugMode(FreeColDebugger.DebugMode.MENUS) && FreeColDebugger.getDebugRunTurns() > 0) {
        fcc.skipTurns(FreeColDebugger.getDebugRunTurns());
        return false;
    }
    if (game.getTurn().getNumber() == 1) {
        player.addStartGameMessage();
    }
    igc().nextModelMessage();
    return true;
}