public DOMMessage add(DOMMessage msg) {
    if (msg != null)
        add(msg.toXMLElement());
    return this;
}