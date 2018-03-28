public final void readFromXMLPartial(FreeColXMLReader xr) throws XMLStreamException {
    final Class theClass = getClass();
    final String tag = xr.getLocalName();
    int n = xr.getAttributeCount();
    setId(xr.readId());
    for (int i = 0; i < n; i++) {
        String name = xr.getAttributeLocalName(i);
        if (ID_ATTRIBUTE_TAG.equals(name) || PARTIAL_ATTRIBUTE_TAG.equals(name))
            continue;
        try {
            Introspector intro = new Introspector(theClass, name);
            intro.setter(this, xr.getAttributeValue(i));
        } catch (Exception e) {
            logger.log(Level.WARNING, "Could not set field " + name, e);
        }
    }
    xr.closeTag(tag);
}