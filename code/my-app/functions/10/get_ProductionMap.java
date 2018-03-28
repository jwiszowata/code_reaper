public AbstractGoods get(GoodsType type) {
    Object value = cache.get(type);
    if (value == null) {
        return new AbstractGoods(type, 0);
    } else if (value instanceof Integer) {
        return new AbstractGoods(type, (Integer) value);
    } else {
        return ((ProductionTree) value).get(type);
    }
}