protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (name != null) {
        xw.writeAttribute(NAME_TAG, name);
    }
    if (key != null) {
        xw.writeAttribute(KEY_TAG, key);
    }
    xw.writeAttribute(TYPE_TAG, type);
    xw.writeAttribute(CLAIMABLE_TAG, claimable);
    xw.writeAttribute(DISCOVERABLE_TAG, discoverable);
    if (parent != null) {
        xw.writeAttribute(PARENT_TAG, parent);
    }
    if (discoveredIn != null) {
        xw.writeAttribute(DISCOVERED_IN_TAG, discoveredIn.getNumber());
    }
    if (discoveredBy != null) {
        xw.writeAttribute(DISCOVERED_BY_TAG, discoveredBy);
    }
    if (scoreValue > 0) {
        xw.writeAttribute(SCORE_VALUE_TAG, scoreValue);
    }
}