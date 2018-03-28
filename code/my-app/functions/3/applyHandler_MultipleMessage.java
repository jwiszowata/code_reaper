public Message applyHandler(DOMMessageHandler handler, Connection connection) {
    return DOMUtils.handleList(handler, connection, this.elements);
}