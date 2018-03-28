public List<AbstractGoods> getFullRequiredGoods(BuildableType buildable) {
    if (buildable == null)
        return Collections.<AbstractGoods>emptyList();
    List<AbstractGoods> required = new ArrayList<>();
    for (AbstractGoods ag : buildable.getRequiredGoodsList()) {
        int amount = ag.getAmount();
        GoodsType type = ag.getType();
        while (type != null) {
            if (amount <= this.getGoodsCount(type))
                break;
            required.add(0, new AbstractGoods(type, amount - this.getGoodsCount(type)));
            type = type.getInputType();
        }
    }
    return required;
}