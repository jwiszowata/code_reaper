private void multiple(MultipleMessage message) {
    Message result = message.applyHandler(this, null);
    if (result != null) {
        logger.warning("Multiple message -> " + result.getType());
    }
}