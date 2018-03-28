public Element handle(DOMMessage message) throws FreeColException {
    Element element = message.toXMLElement();
    return handleElement(element);
}