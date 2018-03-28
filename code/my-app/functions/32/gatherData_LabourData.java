private void gatherData(Player player) {
    List<UnitType> labourTypes = getLabourTypes(player);
    for (Unit unit : transform(player.getUnits(), u -> labourTypes.contains(u.getType()))) {
        Location location = unit.getLocation();
        UnitData data = getUnitData(unit.getType());
        if (location instanceof WorkLocation) {
            incrementColonyCount(location.getColony(), unit, data);
        } else if (location instanceof Europe) {
            incrementOutsideWorker(data, unit, UNITS_IN_EUROPE_GETTER);
        } else if (location instanceof Tile && ((Tile) location).hasSettlement()) {
            incrementColonyCount((Colony) location.getSettlement(), unit, data);
        } else if (location instanceof Unit) {
            incrementOutsideWorker(data, unit, UNITS_AT_SEA_GETTER);
        } else {
            incrementOutsideWorker(data, unit, UNITS_ON_LAND_GETTER);
        }
    }
    summarize();
    for (UnitData unitData : unitDataMap.values()) {
        LocationData total = unitData.getTotal();
        GoodsType expertProduction = unitData.getUnitType().getExpertProduction();
        if (expertProduction != null) {
            for (Colony c : player.getColonyList()) {
                int net = c.getNetProductionOf(expertProduction);
                if (unitData.details.containsKey(c)) {
                    unitData.getLocationData(c).netProduction = net;
                }
                total.netProduction += net;
            }
        }
    }
}