public Element handle(FreeColServer freeColServer, Connection connection) {
    Message m = applyHandler(connection.getDOMMessageHandler(), connection);
    return (m == null) ? null : ((DOMMessage) m).toXMLElement();
}