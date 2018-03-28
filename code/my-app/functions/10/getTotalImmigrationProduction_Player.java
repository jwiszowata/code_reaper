public int getTotalImmigrationProduction() {
    if (!isColonial())
        return 0;
    final List<GoodsType> immigrationGoodsTypes = getSpecification().getImmigrationGoodsTypeList();
    int production = sum(getColonies(), c -> sum(immigrationGoodsTypes, gt -> c.getTotalProductionOf(gt)));
    final Europe europe = getEurope();
    if (europe != null)
        production += europe.getImmigration(production);
    return production;
}