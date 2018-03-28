public boolean sendAndWaitElement(Element element) {
    if (element == null)
        return true;
    final String tag = element.getTagName();
    try {
        askInternal(element);
        logger.fine("SendAndWait: " + tag);
        return true;
    } catch (IOException ioe) {
        logger.log(Level.WARNING, "SendAndWait fail: " + tag, ioe);
    }
    return false;
}