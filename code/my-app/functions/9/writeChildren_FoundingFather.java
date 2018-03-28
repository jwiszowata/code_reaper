protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (Event event : getEvents()) event.toXML(xw);
    for (AbstractUnit unit : getUnitList()) {
        xw.writeStartElement(UNIT_TAG);
        xw.writeAttribute(ID_ATTRIBUTE_TAG, unit);
        xw.writeEndElement();
    }
}