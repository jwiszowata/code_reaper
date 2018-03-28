protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (ProductionType productionType : productionTypes) {
        productionType.toXML(xw);
    }
}