private Connection check(String operation, String type) {
    final Connection c = getConnection();
    if (c == null) {
        logger.log(Level.WARNING, "Not connected, did not " + operation + ": " + type);
        return null;
    }
    return c;
}