public double getStrengthRatio(Player other, boolean naval) {
    NationSummary ns = getNationSummary(other);
    if (ns == null)
        return -1.0;
    int strength = calculateStrength(naval);
    return strengthRatio((double) strength, ns.getMilitaryStrength());
}