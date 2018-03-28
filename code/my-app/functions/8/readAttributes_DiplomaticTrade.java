protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    this.context = xr.getAttribute(CONTEXT_TAG, TradeContext.class, (TradeContext) null);
    this.sender = xr.getAttribute(getGame(), SENDER_TAG, Player.class, (Player) null);
    this.recipient = xr.getAttribute(getGame(), RECIPIENT_TAG, Player.class, (Player) null);
    this.status = xr.getAttribute(STATUS_TAG, TradeStatus.class, TradeStatus.REJECT_TRADE);
    this.version = xr.getAttribute(VERSION_TAG, 0);
}