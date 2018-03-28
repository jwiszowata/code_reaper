public Element toXMLElement() {
    DOMMessage result = new DOMMessage(TAG);
    for (Element e : this.elements) result.add(e);
    return result.toXMLElement();
}