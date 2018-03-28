protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(X_TAG, this.x);
    xw.writeAttribute(Y_TAG, this.y);
    xw.writeAttribute(TYPE_TAG, type);
    if (owner != null) {
        xw.writeAttribute(OWNER_TAG, owner);
    }
    if (owningSettlement != null) {
        if (owningSettlement.isDisposed() || owningSettlement.getId() == null) {
            this.owningSettlement = null;
        } else {
            xw.writeAttribute(OWNING_SETTLEMENT_TAG, owningSettlement);
        }
    }
    xw.writeAttribute(STYLE_TAG, style);
    if (region != null) {
        xw.writeAttribute(REGION_TAG, region);
    }
    if (moveToEurope != null) {
        xw.writeAttribute(MOVE_TO_EUROPE_TAG, moveToEurope.booleanValue());
    }
    if (highSeasCount >= 0) {
        xw.writeAttribute(CONNECTED_TAG, highSeasCount);
    }
    if (contiguity >= 0) {
        xw.writeAttribute(CONTIGUITY_TAG, contiguity);
    }
}