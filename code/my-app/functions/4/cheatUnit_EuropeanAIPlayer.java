private AIUnit cheatUnit(List<RandomChoice<UnitType>> rc, String what, LogBuilder lb) {
    UnitType unitToPurchase = RandomChoice.getWeightedRandom(logger, "Cheat which unit", rc, getAIRandom());
    return (unitToPurchase == null) ? null : cheatUnit(unitToPurchase, what, lb);
}