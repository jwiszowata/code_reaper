private AIUnit cheatUnit(UnitType unitType, String what, LogBuilder lb) {
    final Player player = getPlayer();
    final Europe europe = player.getEurope();
    int cost = europe.getUnitPrice(unitType);
    cheatGold(cost, lb);
    AIUnit result = trainAIUnitInEurope(unitType);
    lb.add(" to build ", what, " ", unitType.getSuffix(), ((result != null) ? "" : "(failed)"), ", ");
    if (result == null)
        return null;
    player.logCheat("Build " + result.getUnit());
    return result;
}