public final Comparator<Unit> getMilitaryStrengthComparator() {
    return (u1, u2) -> Double.compare(calculateCombatOdds(u1, u2).win, calculateCombatOdds(u2, u1).win);
}