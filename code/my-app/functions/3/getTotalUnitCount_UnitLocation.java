public int getTotalUnitCount() {
    return sum(getUnits(), u -> 1 + u.getUnitCount());
}