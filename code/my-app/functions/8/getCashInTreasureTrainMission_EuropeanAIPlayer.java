public Mission getCashInTreasureTrainMission(AIUnit aiUnit) {
    String reason = CashInTreasureTrainMission.invalidReason(aiUnit);
    if (reason != null)
        return null;
    final Unit unit = aiUnit.getUnit();
    Location loc = CashInTreasureTrainMission.findTarget(aiUnit, cashInRange, unit.isInEurope());
    return (loc == null) ? null : new CashInTreasureTrainMission(getAIMain(), aiUnit, loc);
}