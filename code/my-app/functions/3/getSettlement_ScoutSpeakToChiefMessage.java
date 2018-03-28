public IndianSettlement getSettlement(Game game) {
    return game.getFreeColGameObject(getStringAttribute(SETTLEMENT_TAG), IndianSettlement.class);
}