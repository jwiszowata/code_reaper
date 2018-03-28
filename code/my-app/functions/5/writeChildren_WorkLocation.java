protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (productionType != null)
        productionType.toXML(xw);
}