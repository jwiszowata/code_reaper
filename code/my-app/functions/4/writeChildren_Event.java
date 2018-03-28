protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (Limit limit : getLimits()) limit.toXML(xw);
}