public Element toXMLElement() {
    return new DOMMessage(TAG, ACTION_TAG, getAction().toString()).add(this.nt).toXMLElement();
}