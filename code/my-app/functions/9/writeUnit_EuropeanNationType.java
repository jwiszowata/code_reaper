private void writeUnit(FreeColXMLWriter xw, String id, AbstractUnit au, boolean expert) throws XMLStreamException {
    xw.writeStartElement(UNIT_TAG);
    xw.writeAttribute(ID_ATTRIBUTE_TAG, id);
    xw.writeAttribute(TYPE_TAG, au);
    xw.writeAttribute(ROLE_TAG, au.getRoleId());
    if (expert)
        xw.writeAttribute(EXPERT_STARTING_UNITS_TAG, expert);
    xw.writeEndElement();
}