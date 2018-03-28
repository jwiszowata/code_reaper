public <T extends DOMMessage> boolean send(T message) {
    return sendElement(message.toXMLElement());
}