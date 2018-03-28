public boolean isBadlyDefended() {
    return getTotalDefencePower() < 0.95 * getUnitCount() - 2.5;
}