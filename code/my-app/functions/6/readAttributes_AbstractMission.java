protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    unit = xr.makeFreeColObject(getGame(), UNIT_TAG, Unit.class, true);
    turnCount = xr.getAttribute(TURN_COUNT_TAG, 0);
    repeatCount = xr.getAttribute(REPEAT_COUNT_TAG, 1);
}