private void stopIgnoringMessage(String key) {
    messagesToIgnore.remove(key);
    logger.finer("Ignore message stop: " + key);
}