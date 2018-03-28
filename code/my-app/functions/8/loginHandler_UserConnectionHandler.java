private Element loginHandler(Connection connection, LoginMessage message) {
    final FreeColServer freeColServer = getFreeColServer();
    final ServerPlayer serverPlayer = new ServerPlayer(connection);
    ChangeSet cs = message.serverHandler(freeColServer, serverPlayer);
    ServerPlayer real = message.getPlayerByName(freeColServer.getGame());
    Message m = cs.build(real);
    return (m == null) ? null : ((DOMMessage) m).toXMLElement();
}