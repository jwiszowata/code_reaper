public void logout(Player player, LogoutReason reason) {
    if (player == null)
        return;
    final Game game = getGame();
    if (game.getCurrentPlayer() == player) {
        game.setCurrentPlayer(game.getNextPlayer());
    }
    if (getMyPlayer() == player) {
        getFreeColClient().getConnectController().logout(reason);
    }
}