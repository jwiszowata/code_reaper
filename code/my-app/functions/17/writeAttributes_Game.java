protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (xw.validForSave()) {
        xw.writeAttribute(NEXT_ID_TAG, nextId);
    } else if (xw.getClientPlayer() != null) {
        xw.writeAttribute(CLIENT_USER_NAME_TAG, xw.getClientPlayer().getName());
    }
    xw.writeAttribute(UUID_TAG, getUUID());
    xw.writeAttribute(TURN_TAG, getTurn().getNumber());
    xw.writeAttribute(SPANISH_SUCCESSION_TAG, spanishSuccession);
    if (initialActiveUnitId != null) {
        xw.writeAttribute(INITIAL_ACTIVE_UNIT_ID, initialActiveUnitId);
    }
    if (currentPlayer != null) {
        xw.writeAttribute(CURRENT_PLAYER_TAG, currentPlayer);
    }
}