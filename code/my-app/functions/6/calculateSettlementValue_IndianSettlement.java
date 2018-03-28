public int calculateSettlementValue(int value, Unit unit) {
    Tension tension = this.getAlarm(unit.getOwner());
    if (tension != null)
        value += tension.getValue() / 2;
    return value;
}