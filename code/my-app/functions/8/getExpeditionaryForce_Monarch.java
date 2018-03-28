public Force getExpeditionaryForce() {
    if (expeditionaryForce == null) {
        final Specification spec = getSpecification();
        UnitListOption option = (UnitListOption) spec.getOption(GameOptions.REF_FORCE);
        expeditionaryForce = new Force(spec, option.getOptionValues(), null);
    }
    return expeditionaryForce;
}