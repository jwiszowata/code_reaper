public int evaluateFor(Player player) {
    final Unit unit = getUnit();
    return (!isValid()) ? Integer.MIN_VALUE : unit.evaluateFor(player);
}