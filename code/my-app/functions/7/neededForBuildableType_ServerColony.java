private boolean neededForBuildableType(GoodsType goodsType) {
    final Specification spec = getSpecification();
    List<BuildableType> buildables = new ArrayList<>();
    buildables.addAll(spec.getBuildingTypeList());
    buildables.addAll(spec.getUnitTypesWithoutAbility(Ability.PERSON));
    return any(buildables, bt -> canBuild(bt) && any(bt.getRequiredGoods(), AbstractGoods.matches(goodsType)));
}