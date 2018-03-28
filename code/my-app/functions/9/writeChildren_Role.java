protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (RoleChange rc : getRoleChanges()) {
        xw.writeStartElement(ROLE_CHANGE_TAG);
        xw.writeAttribute(FROM_TAG, rc.from);
        xw.writeAttribute(CAPTURE_TAG, rc.capture);
        xw.writeEndElement();
    }
}