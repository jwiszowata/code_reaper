private void addInput(GoodsType type, int amount) {
    if (inputs == null)
        inputs = new ArrayList<>(1);
    inputs.add(new AbstractGoods(type, amount));
}