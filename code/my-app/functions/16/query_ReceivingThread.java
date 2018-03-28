private Thread query(DOMMessage msg, final int replyId) {
    return new Thread(this.connection.getName() + "-query-" + replyId + "-" + msg.getType()) {

        @Override
        public void run() {
            final String tag = msg.getType();
            try {
                ReceivingThread.this.connection.handleQuery(msg, replyId);
            } catch (FreeColException fce) {
                logger.log(Level.WARNING, "Query " + replyId + " handler for " + tag + " failed", fce);
            } catch (IOException ioe) {
                logger.log(Level.WARNING, "Query " + replyId + " response send for " + tag + " failed", ioe);
            }
        }
    };
}