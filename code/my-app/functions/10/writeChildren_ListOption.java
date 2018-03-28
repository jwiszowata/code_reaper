protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    if (template != null) {
        xw.writeStartElement(TEMPLATE_TAG);
        template.toXML(xw);
        xw.writeEndElement();
    }
    for (AbstractOption option : value) {
        option.toXML(xw);
    }
}