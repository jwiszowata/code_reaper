public int getPlunder(Unit attacker, Random random) {
    RandomRange range = getPlunderRange(attacker);
    return (range == null) ? 0 : range.getAmount("Plunder " + getName(), random, false);
}