private LocationData getLocationData(Colony colony) {
    LocationData colonyData = details.get(colony);
    if (colonyData == null) {
        colonyData = new LocationData(this);
        details.put(colony, colonyData);
    }
    return colonyData;
}