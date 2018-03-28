public void tradeGoodsWithSettlement(IndianSettlement is) {
    final Specification spec = getSpecification();
    for (GoodsType gt : transform(spec.getGoodsTypeList(), GoodsType::getMilitary)) {
        int goodsInStock = getGoodsCount(gt);
        if (goodsInStock <= 50)
            continue;
        int goodsTraded = goodsInStock / 2;
        is.addGoods(gt, goodsTraded);
        this.removeGoods(gt, goodsTraded);
    }
}