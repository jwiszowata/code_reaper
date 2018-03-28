protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (goodsContainer != null)
        goodsContainer.toXML(xw);
}