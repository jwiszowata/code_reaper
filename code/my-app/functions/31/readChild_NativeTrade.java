protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    String tag = xr.getLocalName();
    Game game = getGame();
    if (SETTLEMENT_TO_UNIT_TAG.equals(tag)) {
        while (xr.moreTags()) {
            tag = xr.getLocalName();
            if (NativeTradeItem.TAG.equals(tag)) {
                NativeTradeItem nti = new NativeTradeItem(game, xr);
                if (nti != null)
                    this.settlementToUnit.add(nti);
            } else {
                logger.warning("SettlementToUnit-item expected, not: " + tag);
            }
        }
    } else if (UNIT_TO_SETTLEMENT_TAG.equals(tag)) {
        while (xr.moreTags()) {
            tag = xr.getLocalName();
            if (NativeTradeItem.TAG.equals(tag)) {
                NativeTradeItem nti = new NativeTradeItem(game, xr);
                if (nti != null)
                    this.unitToSettlement.add(nti);
            } else {
                logger.warning("UnitToSettlement-item expected, not: " + tag);
            }
        }
    } else if (NativeTradeItem.TAG.equals(tag)) {
        this.item = new NativeTradeItem(game, xr);
    } else {
        super.readChild(xr);
    }
}