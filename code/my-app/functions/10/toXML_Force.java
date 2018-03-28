public void toXML(FreeColXMLWriter xw, String tag) throws XMLStreamException {
    xw.writeStartElement(tag);
    xw.writeStartElement(NAVAL_UNITS_TAG);
    for (AbstractUnit unit : this.navalUnits) unit.toXML(xw);
    xw.writeEndElement();
    xw.writeStartElement(LAND_UNITS_TAG);
    for (AbstractUnit unit : this.landUnits) unit.toXML(xw);
    xw.writeEndElement();
    xw.writeEndElement();
}