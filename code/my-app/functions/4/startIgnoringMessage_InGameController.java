private void startIgnoringMessage(String key, Turn turn) {
    messagesToIgnore.put(key, turn.getNumber());
    logger.finer("Ignore message start: " + key);
}