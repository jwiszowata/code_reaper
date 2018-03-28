private void ready(Element element) {
    final Game game = getGame();
    final ReadyMessage message = new ReadyMessage(game, element);
    Player player = message.getPlayer(game);
    boolean ready = message.getValue();
    if (player != null) {
        player.setReady(ready);
        getGUI().refreshPlayersTable();
    }
}