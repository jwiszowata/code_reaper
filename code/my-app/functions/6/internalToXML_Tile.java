public void internalToXML(FreeColXMLWriter xw, String tag) throws XMLStreamException {
    xw.writeStartElement(tag);
    writeAttributes(xw);
    writeChildren(xw);
    xw.writeEndElement();
}