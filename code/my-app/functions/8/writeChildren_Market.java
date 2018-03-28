protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (xw.validFor(owner)) {
        for (MarketData data : sort(marketData.values())) {
            data.toXML(xw);
        }
    }
}