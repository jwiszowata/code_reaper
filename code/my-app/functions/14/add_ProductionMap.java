public void add(AbstractGoods goods) {
    if (goods.getType().getStoredAs() != root.getType()) {
        throw new IllegalArgumentException(goods.getType().getId() + " is not stored as " + root.getType());
    } else {
        AbstractGoods leaf = find(leafs, AbstractGoods.matches(goods.getType()));
        if (leaf != null) {
            leaf.setAmount(leaf.getAmount() + goods.getAmount());
            root.setAmount(root.getAmount() + goods.getAmount());
            return;
        }
        leafs.add(new AbstractGoods(goods));
        root.setAmount(root.getAmount() + goods.getAmount());
    }
}