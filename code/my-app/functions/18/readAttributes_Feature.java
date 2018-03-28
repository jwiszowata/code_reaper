protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final Specification spec = getSpecification();
    String str = xr.getAttribute(SOURCE_TAG, (String) null);
    if (str == null) {
        setSource(null);
    } else if (spec != null) {
        setSource(spec.findType(str));
    }
    int firstTurn = xr.getAttribute(FIRST_TURN_TAG, UNDEFINED);
    if (firstTurn != UNDEFINED)
        setFirstTurn(new Turn(firstTurn));
    int lastTurn = xr.getAttribute(LAST_TURN_TAG, UNDEFINED);
    if (lastTurn != UNDEFINED)
        setLastTurn(new Turn(lastTurn));
    duration = xr.getAttribute(DURATION_TAG, 0);
    temporary = xr.getAttribute(TEMPORARY_TAG, false);
}