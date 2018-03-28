protected void gatherData() {
    for (Unit u : CollectionUtils.transform(getMyPlayer().getUnits(), Unit::isCarrier)) {
        addUnit(u, "carriers");
    }
}