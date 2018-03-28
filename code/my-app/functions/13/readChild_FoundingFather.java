protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final String tag = xr.getLocalName();
    if (UNIT_TAG.equals(tag)) {
        addUnit(new AbstractUnit(xr));
    } else if (Event.TAG.equals(tag)) {
        addEvent(new Event(xr, spec));
    } else if (UPGRADE_TAG.equals(tag)) {
        xr.closeTag(UPGRADE_TAG);
    } else {
        super.readChild(xr);
    }
}