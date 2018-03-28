public boolean isOffensiveUnit() {
    return unitType.isOffensive() || getRole().isOffensive();
}