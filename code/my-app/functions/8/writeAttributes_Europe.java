protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (xw.validFor(getOwner())) {
        xw.writeAttribute(RECRUIT_PRICE_TAG, recruitPrice);
        xw.writeAttribute(RECRUIT_LOWER_CAP_TAG, recruitLowerCap);
        xw.writeAttribute(OWNER_TAG, owner);
    }
}