protected Element handler(boolean current, Connection connection, DOMMessage message) {
    Message m = internalHandler(current, connection, message);
    return (m == null) ? null : ((DOMMessage) m).toXMLElement();
}