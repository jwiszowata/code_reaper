public void toXML(FreeColXMLWriter xw) throws XMLStreamException {
    if (validate())
        toXML(xw, TAG);
}