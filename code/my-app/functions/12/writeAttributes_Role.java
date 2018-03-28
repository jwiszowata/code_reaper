protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (downgrade != null) {
        xw.writeAttribute(DOWNGRADE_TAG, downgrade);
    }
    if (expertUnit != null) {
        xw.writeAttribute(EXPERT_UNIT_TAG, expertUnit);
    }
    if (maximumCount > 1) {
        xw.writeAttribute(MAXIMUM_COUNT_TAG, maximumCount);
    }
}