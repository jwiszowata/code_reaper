public Force getWarSupportForce() {
    final Specification spec = getSpecification();
    UnitListOption option = (UnitListOption) spec.getOption(GameOptions.WAR_SUPPORT_FORCE);
    return new Force(spec, option.getOptionValues(), null);
}