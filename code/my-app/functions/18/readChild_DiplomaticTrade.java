protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (ColonyTradeItem.TAG.equals(tag)) {
        add(new ColonyTradeItem(getGame(), xr));
    } else if (GoldTradeItem.TAG.equals(tag)) {
        add(new GoldTradeItem(getGame(), xr));
    } else if (GoodsTradeItem.TAG.equals(tag)) {
        add(new GoodsTradeItem(getGame(), xr));
    } else if (InciteTradeItem.TAG.equals(tag)) {
        add(new InciteTradeItem(getGame(), xr));
    } else if (StanceTradeItem.TAG.equals(tag)) {
        add(new StanceTradeItem(getGame(), xr));
    } else if (UnitTradeItem.TAG.equals(tag)) {
        add(new UnitTradeItem(getGame(), xr));
    } else {
        super.readChild(xr);
    }
}