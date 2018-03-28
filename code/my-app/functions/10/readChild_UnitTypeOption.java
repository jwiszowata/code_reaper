protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final String tag = xr.getLocalName();
    if (CHOICE_TAG.equals(tag)) {
        choices.add(xr.getType(spec, VALUE_TAG, UnitType.class, (UnitType) null));
        xr.closeTag(CHOICE_TAG);
    } else {
        super.readChild(xr);
    }
}