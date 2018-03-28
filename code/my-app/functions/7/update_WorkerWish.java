public void update(UnitType unitType, boolean expertNeeded, int value) {
    setValue(value);
    this.unitType = unitType;
    this.expertNeeded = expertNeeded;
    if (transportable != null)
        transportable.setTransportPriority(value);
}