public float getBurnProbability() {
    final Specification spec = getSpecification();
    return 0.01f * spec.getInteger(GameOptions.BURN_PROBABILITY);
}