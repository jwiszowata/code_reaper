protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(TURN_TAG, this.turn.getNumber());
    xw.writeAttribute(EVENT_TYPE_TAG, this.eventType);
    if (playerId != null)
        xw.writeAttribute(PLAYER_ID_TAG, this.playerId);
    xw.writeAttribute(SCORE_TAG, this.score);
}