public final Element handle(Connection connection, Element element) {
    if (element == null)
        return null;
    final FreeColServer freeColServer = getFreeColServer();
    final String tag = element.getTagName();
    final DOMNetworkRequestHandler handler = handlerMap.get(tag);
    Element ret = null;
    if (handler == null) {
        logger.warning("No " + freeColServer.getServerState().toString().toLowerCase() + " handler for " + tag);
    } else {
        try {
            ret = handler.handle(connection, element);
            logger.log(Level.FINEST, "Handling " + tag + " ok = " + ((ret == null) ? "null" : ret.getTagName()));
        } catch (Exception e) {
            logger.log(Level.WARNING, "Handling " + tag + " failed", e);
            connection.sendReconnect();
        }
    }
    return ret;
}