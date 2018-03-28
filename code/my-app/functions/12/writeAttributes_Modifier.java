protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(VALUE_TAG, value);
    xw.writeAttribute(TYPE_TAG, modifierType);
    if (incrementType != null) {
        xw.writeAttribute(INCREMENT_TYPE_TAG, incrementType);
        xw.writeAttribute(INCREMENT_TAG, increment);
    }
    if (modifierIndex >= 0) {
        xw.writeAttribute(INDEX_TAG, modifierIndex);
    }
}