protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (GIFTS_TAG.equals(tag)) {
        this.gifts = new RandomRange(xr);
        xr.closeTag(GIFTS_TAG);
    } else if (PlunderType.TAG.equals(tag)) {
        addPlunder(new PlunderType(xr, getSpecification()));
    } else {
        super.readChild(xr);
    }
}