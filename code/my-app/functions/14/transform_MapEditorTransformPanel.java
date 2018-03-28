public void transform(Tile t) {
    if (!t.isLand() || t.hasSettlement() || nativeNation == null)
        return;
    UnitType skill = first(((IndianNationType) nativeNation.getType()).getSkills()).getObject();
    Player nativePlayer = getGame().getPlayerByNation(nativeNation);
    if (nativePlayer == null)
        return;
    String name = nativePlayer.getSettlementName(null);
    ServerIndianSettlement sis = new ServerIndianSettlement(t.getGame(), nativePlayer, name, t, false, skill, null);
    nativePlayer.addSettlement(sis);
    sis.placeSettlement(true);
    sis.addUnits(null);
    logger.info("Add settlement " + sis.getName() + " to tile " + t);
}