public List<AbstractUnit> getStartingUnits() {
    boolean ex = getSpecification().getBoolean(GameOptions.EXPERT_STARTING_UNITS);
    return getStartingUnits(String.valueOf(ex));
}