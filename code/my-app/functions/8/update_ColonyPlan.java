public void update() {
    profileType = ProfileType.getProfileTypeFromSize(colony.getUnitCount());
    Map<GoodsType, Map<WorkLocation, Integer>> production = createProductionMap();
    updateGoodsTypeLists(production);
    updateRawMaterials(production);
    updateBuildableTypes();
    updatePlans(production);
}