public boolean trainUnitInEurope(UnitType unitType) {
    if (!requireOurTurn() || unitType == null)
        return false;
    final Player player = getMyPlayer();
    final Europe europe = player.getEurope();
    if (!player.checkGold(europe.getUnitPrice(unitType))) {
        getGUI().showInformationMessage("info.notEnoughGold");
        return false;
    }
    EuropeWas europeWas = new EuropeWas(europe);
    Unit newUnit = null;
    boolean ret = askServer().trainUnitInEurope(getGame(), unitType) && (newUnit = europeWas.getNewUnit()) != null;
    if (ret) {
        europeWas.fireChanges();
        player.setNextActiveUnit(newUnit);
        getGUI().setActiveUnit(newUnit);
        updateGUI(null);
    }
    return ret;
}