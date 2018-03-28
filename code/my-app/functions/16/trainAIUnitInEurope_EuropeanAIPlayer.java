public AIUnit trainAIUnitInEurope(UnitType unitType) {
    if (unitType == null) {
        throw new IllegalArgumentException("Invalid UnitType.");
    }
    AIUnit aiUnit = null;
    Europe europe = getPlayer().getEurope();
    if (europe == null)
        return null;
    int n = europe.getUnitCount();
    if (AIMessage.askTrainUnitInEurope(this, unitType) && europe.getUnitCount() == n + 1) {
        aiUnit = getAIUnit(europe.getUnitList().get(n));
        if (aiUnit != null)
            addAIUnit(aiUnit);
    }
    return aiUnit;
}