protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (TradeItem item : this.items) item.toXML(xw);
}