protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(TYPE_TAG, this.type);
    xw.writeAttribute(AMOUNT_TAG, this.amount);
    if (this.location != null) {
        xw.writeLocationAttribute(LOCATION_TAG, this.location);
    }
}