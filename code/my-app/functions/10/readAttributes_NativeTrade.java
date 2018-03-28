protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    final Game game = getGame();
    super.readAttributes(xr);
    this.buy = xr.getAttribute(BUY_TAG, false);
    this.count = xr.getAttribute(COUNT_TAG, -1);
    this.gift = xr.getAttribute(GIFT_TAG, false);
    this.sell = xr.getAttribute(SELL_TAG, false);
    this.is = xr.getAttribute(game, SETTLEMENT_TAG, IndianSettlement.class, (IndianSettlement) null);
    this.unit = xr.getAttribute(game, UNIT_TAG, Unit.class, (Unit) null);
}