protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(CONTEXT_TAG, this.context);
    xw.writeAttribute(SENDER_TAG, this.sender);
    xw.writeAttribute(RECIPIENT_TAG, this.recipient);
    xw.writeAttribute(STATUS_TAG, this.status);
    xw.writeAttribute(VERSION_TAG, this.version);
}