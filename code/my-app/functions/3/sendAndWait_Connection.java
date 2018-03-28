public <T extends DOMMessage> void sendAndWait(T message) throws IOException {
    sendAndWaitElement(message.toXMLElement());
}