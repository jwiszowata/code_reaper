public int lowerTax(Random random) {
    final Specification spec = getSpecification();
    int taxAdjustment = spec.getInteger(GameOptions.TAX_ADJUSTMENT);
    int oldTax = player.getTax();
    int adjust = Math.max(1, 10 - taxAdjustment);
    adjust = 1 + randomInt(logger, "Tax reduction", random, adjust);
    return Math.max(oldTax - adjust, Monarch.MINIMUM_TAX_RATE);
}