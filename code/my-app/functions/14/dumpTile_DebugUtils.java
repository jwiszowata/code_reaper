public static void dumpTile(final FreeColClient freeColClient, final Tile tile) {
    final FreeColServer server = freeColClient.getFreeColServer();
    final Game game = freeColClient.getGame();
    final Game sGame = server.getGame();
    final Player player = freeColClient.getMyPlayer();
    System.err.println("\nClient (" + game.getClientUserName() + "/" + player.getId() + "):");
    tile.save(System.err, WriteScope.toClient(player), true);
    System.err.println("\n\nServer:");
    Tile sTile = sGame.getFreeColGameObject(tile.getId(), Tile.class);
    sTile.save(System.err, WriteScope.toServer(), true);
    System.err.println("\n\nSave:");
    sTile.save(System.err, WriteScope.toSave(), true);
    System.err.println('\n');
}