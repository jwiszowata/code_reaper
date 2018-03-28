public void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (CHILD_TAG.equals(tag)) {
        addChild(xr.makeFreeColObject(getGame(), ID_ATTRIBUTE_TAG, Region.class, true));
        xr.closeTag(CHILD_TAG);
    } else {
        super.readChild(xr);
    }
}