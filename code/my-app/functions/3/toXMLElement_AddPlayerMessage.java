public Element toXMLElement() {
    return new DOMMessage(TAG).add(this.players).toXMLElement();
}