public static void setDerivedAttributes(Specification spec) {
    for (GoodsType g : spec.getGoodsTypeList()) {
        g.buildingMaterial = false;
        g.makes = null;
    }
    List<BuildableType> buildableTypes = new ArrayList<>();
    buildableTypes.addAll(spec.getBuildingTypeList());
    buildableTypes.addAll(spec.getUnitTypeList());
    buildableTypes.addAll(spec.getRolesList());
    forEach(flatten(buildableTypes, BuildableType::getRequiredGoods), ag -> ag.getType().buildingMaterial = true);
    for (GoodsType g : spec.getGoodsTypeList()) {
        if (g.madeFrom != null)
            g.madeFrom.makes = g;
    }
}