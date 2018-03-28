public <T extends DOMMessage> DOMMessage ask(Game game, T message) {
    Element reply;
    try {
        reply = ask(message);
    } catch (IOException e) {
        return new ErrorMessage(StringTemplate.template("connection.io").addName("%extra%", e.getMessage()));
    }
    return DOMUtils.createMessage(game, reply);
}