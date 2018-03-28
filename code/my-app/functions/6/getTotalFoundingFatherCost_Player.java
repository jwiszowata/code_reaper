public int getTotalFoundingFatherCost() {
    final Specification spec = getSpecification();
    int base = spec.getInteger(GameOptions.FOUNDING_FATHER_FACTOR);
    int count = getFatherCount();
    return (count == 0) ? base : 2 * (count + 1) * base + 1;
}