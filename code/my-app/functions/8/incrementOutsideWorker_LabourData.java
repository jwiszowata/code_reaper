private void incrementOutsideWorker(UnitData expert, Unit unit, UnitData workingAs, LocationData.Getter getter) {
    if (unit.getType() == workingAs.unitType) {
        getter.getLocationData(expert).workingProfessionals.colonists++;
    } else {
        getter.getLocationData(expert).workingAmateurs++;
        getter.getLocationData(workingAs).otherWorkingAmateurs.colonists++;
    }
}