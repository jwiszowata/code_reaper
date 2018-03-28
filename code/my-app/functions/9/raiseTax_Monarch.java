public int raiseTax(Random random) {
    final Specification spec = getSpecification();
    int taxAdjustment = spec.getInteger(GameOptions.TAX_ADJUSTMENT);
    int turn = getGame().getTurn().getNumber();
    int oldTax = player.getTax();
    int adjust = Math.max(1, (6 - taxAdjustment) * 10);
    adjust = 1 + randomInt(logger, "Tax rise", random, 5 + turn / adjust);
    return Math.min(oldTax + adjust, taxMaximum());
}