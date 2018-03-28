protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    Player player = xw.getClientPlayer();
    if ((player == null || player.canSee(this)) && (settlement == null || xw.validFor(settlement.getOwner()))) {
        super.writeChildren(xw);
    }
    if (settlement != null)
        settlement.toXML(xw);
    if (tileItemContainer != null)
        tileItemContainer.toXML(xw);
    if (xw.validForSave() && cachedTiles != null) {
        for (Player p : getGame().getLiveEuropeanPlayerList()) {
            Tile t = getCachedTile(p);
            if (t == null)
                continue;
            if (t == this && getIndianSettlement() != null) {
                t = getTileToCache();
                t.setIndianSettlementInternals(p, getLearnableSkill(p), getWantedGoods(p));
            }
            xw.writeStartElement(CACHED_TILE_TAG);
            xw.writeAttribute(PLAYER_TAG, p);
            xw.writeAttribute(COPIED_TAG, t != this);
            if (t != this) {
                FreeColXMLWriter.WriteScope scope = xw.getWriteScope();
                try {
                    xw.setWriteScope(FreeColXMLWriter.WriteScope.toClient(p));
                    t.internalToXML(xw, TAG);
                } finally {
                    xw.setWriteScope(scope);
                }
            }
            xw.writeEndElement();
        }
    }
}