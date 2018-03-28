private boolean ask(Game game, DOMMessage message) {
    if (message == null)
        return true;
    final Connection c = check("ask", message.getType());
    return (c == null) ? false : c.request(game, message);
}