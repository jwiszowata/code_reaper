private void summarize() {
    for (UnitData unitData : unitDataMap.values()) {
        summarize(unitData, UNITS_IN_EUROPE_GETTER);
        summarize(unitData, UNITS_AT_SEA_GETTER);
        summarize(unitData, UNITS_ON_LAND_GETTER);
        for (final Colony colony : unitData.details.keySet()) {
            summarize(unitData, new LocationData.Getter() {

                @Override
                public LocationData getLocationData(UnitData data) {
                    return data.getLocationData(colony);
                }
            });
        }
    }
}