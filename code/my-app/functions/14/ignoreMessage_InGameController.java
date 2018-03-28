public boolean ignoreMessage(ModelMessage message, boolean flag) {
    String key;
    if (message == null || (key = message.getIgnoredMessageKey()) == null)
        return false;
    if (flag) {
        final Turn turn = getGame().getTurn();
        if (!continueIgnoreMessage(key, turn)) {
            startIgnoringMessage(key, turn);
        }
    } else {
        stopIgnoringMessage(key);
    }
    return true;
}