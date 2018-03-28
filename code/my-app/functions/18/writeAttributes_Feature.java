protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (getSource() != null) {
        xw.writeAttribute(SOURCE_TAG, getSource());
    }
    if (getFirstTurn() != null) {
        xw.writeAttribute(FIRST_TURN_TAG, getFirstTurn().getNumber());
    }
    if (getLastTurn() != null) {
        xw.writeAttribute(LAST_TURN_TAG, getLastTurn().getNumber());
    }
    if (duration != 0) {
        xw.writeAttribute(DURATION_TAG, duration);
    }
    if (temporary) {
        xw.writeAttribute(TEMPORARY_TAG, temporary);
    }
}