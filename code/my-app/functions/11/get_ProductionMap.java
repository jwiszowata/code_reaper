public AbstractGoods get(GoodsType type) {
    if (root.getType() == type) {
        return root;
    } else {
        AbstractGoods leaf = find(leafs, AbstractGoods.matches(type));
        if (leaf != null) {
            return new AbstractGoods(type, leaf.getAmount());
        }
    }
    return null;
}