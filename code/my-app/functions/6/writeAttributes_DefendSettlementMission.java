protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (target != null) {
        xw.writeAttribute(SETTLEMENT_TAG, target.getId());
    }
}