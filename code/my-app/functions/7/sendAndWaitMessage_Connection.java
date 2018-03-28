public boolean sendAndWaitMessage(Message message) {
    if (message == null)
        return true;
    boolean ret = sendAndWaitElement(((DOMMessage) message).toXMLElement());
    logger.fine("SendAndWait: " + message.getType());
    return ret;
}