protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (TradeRouteStop.TAG.equals(tag)) {
        addStop(new TradeRouteStop(getGame(), xr));
    } else {
        super.readChild(xr);
    }
}