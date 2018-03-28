public Element toXMLElement() {
    return new DOMMessage(TAG).add(this.tradeRoute).toXMLElement();
}