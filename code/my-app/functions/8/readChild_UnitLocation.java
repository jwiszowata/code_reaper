protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (Unit.TAG.equals(tag)) {
        addUnit(xr.readFreeColObject(getGame(), Unit.class));
    } else {
        super.readChild(xr);
    }
}