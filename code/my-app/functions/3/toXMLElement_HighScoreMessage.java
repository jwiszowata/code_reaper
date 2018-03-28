public Element toXMLElement() {
    return new DOMMessage(TAG, KEY_TAG, this.key).add(this.scores).toXMLElement();
}