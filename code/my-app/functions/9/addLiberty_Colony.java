public void addLiberty(int amount) {
    List<GoodsType> libertyTypeList = getSpecification().getLibertyGoodsTypeList();
    final int uc = getUnitCount();
    if (calculateRebels(uc, sonsOfLiberty) <= uc + 1 && amount > 0 && !libertyTypeList.isEmpty()) {
        addGoods(libertyTypeList.get(0), amount);
    }
    updateSoL();
    updateProductionBonus();
}