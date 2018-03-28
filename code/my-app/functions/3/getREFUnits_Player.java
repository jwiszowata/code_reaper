public List<AbstractUnit> getREFUnits() {
    return (getPlayerType() == PlayerType.COLONIAL) ? getMonarch().getExpeditionaryForce().getUnitList() : null;
}