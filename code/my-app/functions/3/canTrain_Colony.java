public boolean canTrain(UnitType unitType) {
    return hasAbility(Ability.TEACH) && any(getBuildings(), b -> b.canTeach() && b.canAddType(unitType));
}