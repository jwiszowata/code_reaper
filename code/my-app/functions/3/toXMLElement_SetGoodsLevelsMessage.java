public Element toXMLElement() {
    return new DOMMessage(TAG, COLONY_TAG, this.colonyId).add(data).toXMLElement();
}