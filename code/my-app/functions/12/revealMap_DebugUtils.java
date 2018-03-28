public static void revealMap(final FreeColClient freeColClient, boolean reveal) {
    final FreeColServer server = freeColClient.getFreeColServer();
    final Game game = freeColClient.getGame();
    server.exploreMapForAllPlayers(reveal);
    BooleanOption fogOfWarSetting = game.getSpecification().getBooleanOption(GameOptions.FOG_OF_WAR);
    if (reveal) {
        FreeColDebugger.setNormalGameFogOfWar(fogOfWarSetting.getValue());
        fogOfWarSetting.setValue(false);
    } else {
        fogOfWarSetting.setValue(FreeColDebugger.getNormalGameFogOfWar());
    }
}