public <T extends DOMMessage> Element ask(T message) throws IOException {
    try {
        return askElement(message.toXMLElement());
    } catch (Exception e) {
        logger.log(Level.WARNING, "Unexpected exception", e);
    }
    return null;
}