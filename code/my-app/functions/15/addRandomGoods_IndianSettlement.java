public void addRandomGoods(Random random) {
    HashMap<GoodsType, Integer> goodsMap = new HashMap<>();
    for (AbstractGoods ag : iterable(flatten(getOwnedTiles(), t -> t.getSortedPotential().stream()))) {
        accumulateToMap(goodsMap, ag.getType().getStoredAs(), ag.getAmount(), (a, b) -> a + b);
    }
    double d = randomInt(logger, "Goods at " + getName(), random, 10) * 0.1 + 1.0;
    forEachMapEntry(goodsMap, e -> {
        int i = e.getValue();
        if (!e.getKey().isFoodType())
            i = (int) Math.round(d * e.getValue());
        i = Math.min(i, GoodsContainer.CARGO_SIZE);
        if (i > 0)
            addGoods(e.getKey(), i);
    });
}