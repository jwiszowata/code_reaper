protected void log(DOMMessage message, boolean send) {
    if (message == null)
        return;
    log(message.toXMLElement(), send);
}