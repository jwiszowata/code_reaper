public List<Goods> getGoods() {
    final Game game = getGame();
    List<Goods> result = new ArrayList<>();
    synchronized (this.storedGoods) {
        forEachMapEntry(this.storedGoods, e -> {
            int amount = e.getValue();
            while (amount > 0) {
                result.add(new Goods(game, parent, e.getKey(), ((amount >= CARGO_SIZE) ? CARGO_SIZE : amount)));
                amount -= CARGO_SIZE;
            }
        });
    }
    return result;
}