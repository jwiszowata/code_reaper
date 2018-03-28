public Unit getDefendingUnit(Unit attacker) {
    if (displayUnitCount > 0) {
        return null;
    }
    final CombatModel cm = getGame().getCombatModel();
    final Comparator<Unit> comp = cachingDoubleComparator(u -> cm.getDefencePower(attacker, u));
    return maximize(getUnits(), comp);
}