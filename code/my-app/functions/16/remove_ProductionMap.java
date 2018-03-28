public int remove(AbstractGoods goods) {
    int consumed = goods.getAmount();
    if (goods.getType() == root.getType()) {
        root.setAmount(root.getAmount() - consumed);
        for (AbstractGoods leaf : leafs) {
            leaf.setAmount(Math.min(leaf.getAmount(), root.getAmount()));
        }
    } else {
        AbstractGoods leaf = find(leafs, AbstractGoods.matches(goods.getType()));
        if (leaf != null) {
            leaf.setAmount(leaf.getAmount() - consumed);
            root.setAmount(root.getAmount() - consumed);
        }
    }
    return consumed;
}