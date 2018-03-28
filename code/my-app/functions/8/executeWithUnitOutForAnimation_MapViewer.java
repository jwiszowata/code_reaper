void executeWithUnitOutForAnimation(final Unit unit, final Tile sourceTile, final OutForAnimationCallback r) {
    final JLabel unitLabel = enterUnitOutForAnimation(unit, sourceTile);
    try {
        r.executeWithUnitOutForAnimation(unitLabel);
    } finally {
        releaseUnitOutForAnimation(unit);
    }
}