protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (TradeRouteStop stop : this.stops) stop.toXML(xw);
}