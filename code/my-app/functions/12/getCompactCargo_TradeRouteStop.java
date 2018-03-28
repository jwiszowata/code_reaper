public List<AbstractGoods> getCompactCargo() {
    List<AbstractGoods> result = new ArrayList<>();
    for (GoodsType type : getCargo()) {
        AbstractGoods ag = find(result, AbstractGoods.matches(type));
        if (ag != null) {
            ag.setAmount(ag.getAmount() + GoodsContainer.CARGO_SIZE);
        } else {
            result.add(new AbstractGoods(type, GoodsContainer.CARGO_SIZE));
        }
    }
    return result;
}