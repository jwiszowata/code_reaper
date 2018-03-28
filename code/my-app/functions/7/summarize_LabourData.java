private void summarize(UnitData data, LocationData.Getter getter) {
    LocationData unitLocation = getter.getLocationData(data);
    LocationData summaryLocation = getter.getLocationData(summary);
    data.total.add(unitLocation);
    summaryLocation.add(unitLocation);
    summary.total.add(unitLocation);
}