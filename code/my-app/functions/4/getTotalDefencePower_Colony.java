public double getTotalDefencePower() {
    final CombatModel cm = getGame().getCombatModel();
    return sumDouble(getTile().getUnits(), Unit::isDefensiveUnit, u -> cm.getDefencePower(null, u));
}