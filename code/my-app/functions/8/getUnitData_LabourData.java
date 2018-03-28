public final UnitData getUnitData(UnitType unitType) {
    UnitData data = unitDataMap.get(unitType.getId());
    if (data == null) {
        data = new UnitData(unitType);
        unitDataMap.put(unitType.getId(), data);
    }
    return data;
}