protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    unit = xr.getAttribute(getGame(), UNIT_TAG, Unit.class, (Unit) null);
}