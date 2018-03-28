protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    nextId = xr.getAttribute(NEXT_ID_TAG, -1);
    if (nextId < 0)
        nextId = xr.getAttribute(OLD_NEXT_ID_TAG, 0);
    this.clientUserName = xr.getAttribute(CLIENT_USER_NAME_TAG, (String) null);
    String str = xr.getAttribute(UUID_TAG, (String) null);
    if (str == null) {
        this.uuid = UUID.randomUUID();
    } else {
        try {
            UUID u = UUID.fromString(str);
            this.uuid = u;
        } catch (IllegalArgumentException iae) {
            ;
        }
    }
    turn = new Turn(xr.getAttribute(TURN_TAG, 1));
    spanishSuccession = xr.getAttribute(SPANISH_SUCCESSION_TAG, false);
    initialActiveUnitId = xr.getAttribute(INITIAL_ACTIVE_UNIT_ID, (String) null);
}