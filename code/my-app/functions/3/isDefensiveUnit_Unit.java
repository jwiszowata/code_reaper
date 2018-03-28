public boolean isDefensiveUnit() {
    return (unitType.isDefensive() || getRole().isDefensive()) && !isCarrier();
}