public int getMissionaryLineOfSight() {
    final boolean enhanced = getSpecification().getBoolean(GameOptions.ENHANCED_MISSIONARIES);
    return (enhanced) ? getLineOfSight() : 1;
}