public String getUnitName() {
    return (isSummary()) ? null : Messages.getName(unitType);
}