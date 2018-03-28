public void add(AbstractGoods goods) {
    GoodsType goodsType = goods.getType();
    Object value = cache.get(goodsType);
    if (value == null) {
        GoodsType rootType = goodsType.getStoredAs();
        if (rootType == goodsType) {
            cache.put(goodsType, goods.getAmount());
        } else {
            value = cache.get(rootType);
            if (value instanceof ProductionTree) {
                ((ProductionTree) value).add(goods);
            } else {
                int amount = (value == null) ? 0 : (Integer) value;
                value = new ProductionTree(new AbstractGoods(rootType, amount), goods);
                cache.put(rootType, value);
            }
            cache.put(goodsType, value);
        }
    } else if (value instanceof Integer) {
        cache.put(goodsType, (Integer) value + goods.getAmount());
    } else {
        ((ProductionTree) value).add(goods);
    }
}