public void run() {
    try {
        removeDeadServers();
    } catch (Exception ex) {
        logger.log(Level.WARNING, "Could not remove servers.", ex);
    }
}