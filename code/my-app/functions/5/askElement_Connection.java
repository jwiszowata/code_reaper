public Element askElement(Element element) throws IOException {
    DOMMessage reply = askInternal(element);
    logger.fine("Ask: " + element.getTagName() + ", reply: " + ((reply == null) ? "null" : reply.getType()));
    return (reply == null) ? null : (Element) reply.toXMLElement().getFirstChild();
}