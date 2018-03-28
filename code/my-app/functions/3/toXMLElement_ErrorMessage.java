public Element toXMLElement() {
    return new DOMMessage(TAG, MESSAGE_TAG, this.message).add(this.template).toXMLElement();
}