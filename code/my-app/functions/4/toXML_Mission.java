public final void toXML(FreeColXMLWriter xw) throws XMLStreamException {
    if (isValid())
        toXML(xw, getXMLTagName());
}