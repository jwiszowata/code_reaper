private void logout(Element element) {
    final Game game = getGame();
    final LogoutMessage message = new LogoutMessage(game, element);
    final Player player = message.getPlayer(game);
    final LogoutReason reason = message.getReason();
    game.removePlayer(player);
    getGUI().refreshPlayersTable();
    if (player == getMyPlayer()) {
        getFreeColClient().getConnectController().logout(reason);
    }
}