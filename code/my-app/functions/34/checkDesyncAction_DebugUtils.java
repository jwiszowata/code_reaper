public static boolean checkDesyncAction(final FreeColClient freeColClient) {
    final FreeColServer server = freeColClient.getFreeColServer();
    final Game cGame = freeColClient.getGame();
    final Player cPlayer = freeColClient.getMyPlayer();
    final Game sGame = server.getGame();
    final Map sMap = sGame.getMap();
    final ServerPlayer sPlayer = sGame.getFreeColGameObject(cPlayer.getId(), ServerPlayer.class);
    LogBuilder lb = new LogBuilder(256);
    lb.add("Desynchronization detected\n");
    lb.mark();
    sMap.forEachTile(t -> sPlayer.canSee(t), t -> checkDesyncTile(cGame, sPlayer, t, lb));
    boolean problemDetected = lb.grew();
    boolean goodsProblemDetected = false;
    for (GoodsType sg : sGame.getSpecification().getGoodsTypeList()) {
        int sPrice = sPlayer.getMarket().getBidPrice(sg, 1);
        GoodsType cg = cGame.getSpecification().getGoodsType(sg.getId());
        int cPrice = cPlayer.getMarket().getBidPrice(cg, 1);
        if (sPrice != cPrice) {
            lb.add("Goods prices for ", sg, " differ: ", sPrice, "!=", cPrice, " ");
            goodsProblemDetected = true;
        }
    }
    if (goodsProblemDetected) {
        lb.add("  Server:\n", sPlayer.getMarket(), "\n", "  Client:\n", cPlayer.getMarket(), "\n");
        problemDetected = true;
    }
    if (problemDetected) {
        lb.shrink("\n");
        String err = lb.toString();
        freeColClient.getGUI().showInformationMessage(err);
        logger.severe(err);
    }
    return problemDetected;
}