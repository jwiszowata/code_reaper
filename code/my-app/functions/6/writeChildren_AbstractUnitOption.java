protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    number.toXML(xw, NUMBER_TAG);
    role.toXML(xw, ROLE_TAG);
    unitType.toXML(xw, UNIT_TYPE_TAG);
}