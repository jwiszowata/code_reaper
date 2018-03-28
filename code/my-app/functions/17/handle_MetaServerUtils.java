public Element handle(Connection connection, Element element) throws FreeColException {
    if (element == null)
        return null;
    final String tag = element.getTagName();
    switch(tag) {
        case TrivialMessage.DISCONNECT_TAG:
            disconnect();
            break;
        case ServerListMessage.TAG:
            serverList(new ServerListMessage(element));
            break;
        default:
            logger.warning("MetaInputHandler does not handle: " + tag);
            break;
    }
    return null;
}