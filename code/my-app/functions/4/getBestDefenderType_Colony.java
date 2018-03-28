public UnitType getBestDefenderType() {
    final Predicate<UnitType> defenderPred = ut -> ut.getDefence() > 0 && !ut.isNaval() && ut.isAvailableTo(getOwner());
    return maximize(getSpecification().getUnitTypeList(), defenderPred, UnitType.defenceComparator);
}