public boolean sendElement(Element element) {
    if (element == null)
        return true;
    final String tag = element.getTagName();
    try {
        sendInternal(element);
        log(element, true);
        logger.fine("Send: " + tag);
        return true;
    } catch (IOException ioe) {
        logger.log(Level.WARNING, "Send fail: " + tag, ioe);
    }
    return false;
}