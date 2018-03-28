protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (MarketData.TAG.equals(tag)) {
        MarketData data = xr.readFreeColObject(getGame(), MarketData.class);
        putMarketData(data.getGoodsType(), data);
    } else {
        super.readChild(xr);
    }
}