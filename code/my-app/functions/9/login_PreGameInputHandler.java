private void login(Element element) {
    final LoginMessage message = new LoginMessage(new Game(), element);
    final String user = message.getUserName();
    final boolean single = message.getSinglePlayer();
    final boolean current = message.getCurrentPlayer();
    final ServerState state = message.getState();
    final Game game = message.getGame();
    getFreeColClient().getConnectController().login(state, game, user, single, current);
}