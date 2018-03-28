public List<UnitType> getBuildableUnits() {
    return transform(getSpecification().getUnitTypeList(), ut -> ut.needsGoodsToBuild() && canBuild(ut));
}