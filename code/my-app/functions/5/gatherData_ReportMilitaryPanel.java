protected void gatherData() {
    for (Unit unit : CollectionUtils.transform(getMyPlayer().getUnits(), u -> isReportable(u))) {
        addUnit(unit, unit.getRole().getId());
    }
}