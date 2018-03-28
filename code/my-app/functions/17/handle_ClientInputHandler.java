public Element handle(Connection connection, Element element) throws FreeColException {
    if (element == null)
        return null;
    final String tag = element.getTagName();
    DOMClientNetworkRequestHandler handler = domHandlerMap.get(tag);
    try {
        if (handler == null) {
            logger.warning("Client ignored: " + tag);
        } else {
            handler.handle(connection, element);
            logger.log(Level.FINEST, "Client handled: " + tag);
        }
    } catch (Exception ex) {
        logger.log(Level.WARNING, "Client failed: " + tag, ex);
    }
    return null;
}