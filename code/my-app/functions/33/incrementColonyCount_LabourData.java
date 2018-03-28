private void incrementColonyCount(final Colony colony, Unit unit, UnitData unitData) {
    if (!unit.isInColony()) {
        incrementOutsideWorker(unitData, unit, new LocationData.Getter() {

            @Override
            public LocationData getLocationData(UnitData data) {
                return data.getLocationData(colony);
            }
        });
        return;
    }
    WorkLocation wl = unit.getWorkLocation();
    LocationData colonyData = unitData.getLocationData(colony);
    Unit teacher = unit.getTeacher();
    if (teacher != null) {
        colonyData.students++;
        UnitData learning = getUnitData(unit.getTeachingType(teacher));
        learning.getLocationData(colony).addOtherStudent(unitData.getUnitName());
    }
    if (wl.canTeach())
        colonyData.teachers++;
    GoodsType currentlyWorking = unit.getWorkType();
    int production = (currentlyWorking == null) ? 0 : wl.getProductionOf(unit, currentlyWorking);
    UnitData workingAs = experts.get(currentlyWorking);
    if (workingAs == null) {
        ;
    } else if (workingAs.getUnitType() == unit.getType()) {
        colonyData.getWorkingProfessionals().addProduction(production);
    } else {
        colonyData.workingAmateurs++;
        workingAs.getLocationData(colony).otherWorkingAmateurs.addProduction(production);
    }
}