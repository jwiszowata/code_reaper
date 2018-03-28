public void remove(AbstractGoods goods) {
    Object value = cache.get(goods.getType());
    if (value instanceof ProductionTree) {
        ((ProductionTree) value).remove(goods);
    } else {
        add(new AbstractGoods(goods.getType(), -goods.getAmount()));
    }
}