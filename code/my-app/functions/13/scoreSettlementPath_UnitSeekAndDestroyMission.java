private static int scoreSettlementPath(AIUnit aiUnit, PathNode path, Settlement settlement) {
    if (invalidSettlementReason(aiUnit, settlement) != null) {
        return Integer.MIN_VALUE;
    }
    final Unit unit = aiUnit.getUnit();
    final CombatModel combatModel = unit.getGame().getCombatModel();
    int value = 1020;
    value -= path.getTotalTurns() * 100;
    final double off = combatModel.getOffencePower(unit, settlement);
    value += (int) Math.round(off * 50);
    value = settlement.calculateSettlementValue(value, unit);
    return ((MissionAIPlayer) aiUnit.getAIOwner()).adjustMission(aiUnit, path, UnitSeekAndDestroyMission.class, value);
}