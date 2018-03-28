public void updateImmigrationRequired() {
    if (!isColonial())
        return;
    final Specification spec = getSpecification();
    final Turn turn = getGame().getTurn();
    final int current = immigrationRequired;
    int base = spec.getInteger(GameOptions.CROSSES_INCREMENT);
    int unreduced = Math.round(current / applyModifiers(1f, turn, Modifier.RELIGIOUS_UNREST_BONUS));
    immigrationRequired = (int) applyModifiers(unreduced + base, turn, Modifier.RELIGIOUS_UNREST_BONUS);
    ;
    logger.finest("Immigration for " + getId() + " updated " + current + " -> " + immigrationRequired);
}