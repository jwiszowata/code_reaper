private void addConsumption(GoodsType type, int amount) {
    if (consumption == null) {
        consumption = new TypeCountMap<>();
    }
    consumption.incrementCount(type, amount);
}