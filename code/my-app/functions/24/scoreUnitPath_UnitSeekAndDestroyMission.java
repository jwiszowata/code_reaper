private static int scoreUnitPath(AIUnit aiUnit, PathNode path, Unit defender) {
    if (invalidUnitReason(aiUnit, defender) != null) {
        return Integer.MIN_VALUE;
    }
    final Unit unit = aiUnit.getUnit();
    final Tile tile = path.getLastNode().getTile();
    final int turns = path.getTotalTurns();
    final CombatModel combatModel = unit.getGame().getCombatModel();
    final double off = combatModel.getOffencePower(unit, defender);
    final double def = combatModel.getDefencePower(unit, defender);
    if (tile == null || off <= 0)
        return Integer.MIN_VALUE;
    int value = 1020 - turns * 100;
    value += 100 * (off - def);
    value += 1000 * count(tile.getUnits(), u -> u.canCarryTreasure() && u.getTreasureAmount() > 0);
    if (defender.isNaval()) {
        if (tile.isLand())
            value += 500;
    } else {
        if (defender.hasAbility(Ability.EXPERT_SOLDIER) && !defender.isArmed())
            value += 100;
    }
    return ((MissionAIPlayer) aiUnit.getAIOwner()).adjustMission(aiUnit, path, UnitSeekAndDestroyMission.class, value);
}