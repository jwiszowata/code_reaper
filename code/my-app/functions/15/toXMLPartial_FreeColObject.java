public final void toXMLPartial(FreeColXMLWriter xw, List<String> fields) throws XMLStreamException {
    final Class theClass = getClass();
    try {
        xw.writeStartElement(getXMLTagName());
        xw.writeAttribute(ID_ATTRIBUTE_TAG, getId());
        xw.writeAttribute(PARTIAL_ATTRIBUTE_TAG, true);
        int n = fields.size();
        for (int i = 0; i < n - 1; i += 2) {
            xw.writeAttribute(fields.get(i), fields.get(i + 1));
        }
        xw.writeEndElement();
    } catch (Exception e) {
        logger.log(Level.WARNING, "Partial write failed for " + theClass.getName(), e);
    }
}