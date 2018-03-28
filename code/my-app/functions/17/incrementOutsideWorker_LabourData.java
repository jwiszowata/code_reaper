private void incrementOutsideWorker(UnitData unitData, Unit unit, LocationData.Getter getter) {
    UnitData workingAs = null;
    if (unit.isArmed()) {
        workingAs = soldier;
    } else if (unit.hasAbility(Ability.ESTABLISH_MISSION)) {
        workingAs = missionary;
    } else if (unit.hasAbility(Ability.IMPROVE_TERRAIN)) {
        workingAs = pioneer;
    } else if (unit.hasAbility(Ability.SPEAK_WITH_CHIEF)) {
        workingAs = scout;
    }
    if (workingAs == null) {
        getter.getLocationData(unitData).notWorking++;
    } else {
        incrementOutsideWorker(unitData, unit, workingAs, getter);
    }
}