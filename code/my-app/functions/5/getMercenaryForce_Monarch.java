public Force getMercenaryForce() {
    final Specification spec = getSpecification();
    UnitListOption option = (UnitListOption) spec.getOption(GameOptions.MERCENARY_FORCE);
    return new Force(spec, option.getOptionValues(), null);
}