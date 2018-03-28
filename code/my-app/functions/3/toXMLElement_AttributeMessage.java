public Element toXMLElement() {
    return DOMUtils.createElement(getType(), this.attributes);
}