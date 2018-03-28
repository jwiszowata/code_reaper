public void run() {
    int timesFailed = 0;
    try {
        while (shouldRun()) {
            try {
                listen();
                timesFailed = 0;
            } catch (SAXException | XMLStreamException ex) {
                if (!shouldRun())
                    break;
                logger.log(Level.WARNING, "XML fail", ex);
                if (++timesFailed > MAXIMUM_RETRIES) {
                    disconnect();
                }
            } catch (IOException ioe) {
                if (!shouldRun())
                    break;
                logger.log(Level.WARNING, "IO fail", ioe);
                disconnect();
            }
        }
    } catch (Exception e) {
        logger.log(Level.WARNING, "Unexpected exception.", e);
    } finally {
        askToStop();
    }
    connection.close();
    logger.info("Finished: " + getName());
}