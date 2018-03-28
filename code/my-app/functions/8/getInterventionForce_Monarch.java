public Force getInterventionForce() {
    if (interventionForce == null) {
        final Specification spec = getSpecification();
        UnitListOption option = (UnitListOption) spec.getOption(GameOptions.INTERVENTION_FORCE);
        interventionForce = new Force(spec, option.getOptionValues(), null);
    }
    return interventionForce;
}