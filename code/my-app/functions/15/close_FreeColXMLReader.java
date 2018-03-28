public void close() {
    try {
        super.close();
    } catch (XMLStreamException xse) {
        logger.log(Level.WARNING, "Error closing stream.", xse);
    }
    if (inputStream != null) {
        try {
            inputStream.close();
        } catch (IOException ioe) {
            logger.log(Level.WARNING, "Error closing stream.", ioe);
        }
        inputStream = null;
    }
}