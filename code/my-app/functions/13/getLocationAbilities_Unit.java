private Stream<Ability> getLocationAbilities(String id, Turn turn) {
    final UnitType unitType = getType();
    final Settlement settlement = getSettlement();
    if (settlement != null) {
        return settlement.getAbilities(id, unitType, turn);
    }
    if (isInEurope()) {
        Europe europe = owner.getEurope();
        if (europe != null)
            return europe.getAbilities(id, getType(), turn);
    }
    return Stream.<Ability>empty();
}