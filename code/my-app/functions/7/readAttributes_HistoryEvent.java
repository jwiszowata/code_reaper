protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    turn = new Turn(xr.getAttribute(TURN_TAG, 0));
    eventType = xr.getAttribute(EVENT_TYPE_TAG, HistoryEventType.class, (HistoryEventType) null);
    playerId = xr.getAttribute(PLAYER_ID_TAG, (String) null);
    score = xr.getAttribute(SCORE_TAG, 0);
}