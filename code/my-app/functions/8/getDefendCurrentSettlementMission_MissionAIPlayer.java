public Mission getDefendCurrentSettlementMission(AIUnit aiUnit) {
    if (DefendSettlementMission.invalidReason(aiUnit) != null)
        return null;
    final Unit unit = aiUnit.getUnit();
    final Location loc = unit.getLocation();
    final Settlement settlement = (loc == null) ? null : loc.getSettlement();
    return (settlement != null && settlement.isBadlyDefended()) ? getDefendSettlementMission(aiUnit, settlement) : null;
}