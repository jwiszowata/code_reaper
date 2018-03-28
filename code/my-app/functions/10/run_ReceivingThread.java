public void run() {
    final String tag = msg.getType();
    try {
        ReceivingThread.this.connection.handleUpdate(msg);
    } catch (FreeColException fce) {
        logger.log(Level.WARNING, "Update handler for " + tag + " failed", fce);
    } catch (IOException ioe) {
        logger.log(Level.WARNING, "Update send for " + tag + " failed", ioe);
    }
}