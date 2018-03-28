public synchronized Element handle(Connection connection, Element element) {
    DOMMessage reply = null;
    final String tag = element.getTagName();
    switch(tag) {
        case TrivialMessage.DISCONNECT_TAG:
            disconnect(connection);
            break;
        case RegisterServerMessage.TAG:
            RegisterServerMessage rsm = new RegisterServerMessage(null, element);
            rsm.setAddress(connection.getHostAddress());
            register(rsm);
            break;
        case RemoveServerMessage.TAG:
            remove(new RemoveServerMessage(null, element));
            break;
        case ServerListMessage.TAG:
            reply = serverList();
            break;
        case UpdateServerMessage.TAG:
            UpdateServerMessage usm = new UpdateServerMessage(null, element);
            usm.setAddress(connection.getHostAddress());
            update(usm);
            break;
        default:
            logger.warning("Unknown request: " + tag);
            break;
    }
    return (reply == null) ? null : reply.toXMLElement();
}