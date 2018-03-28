public ProductionInfo getProductionInfo(List<AbstractGoods> input) {
    ProductionInfo result = new ProductionInfo();
    T current = getCurrentlyBuilding();
    if (current != null) {
        final boolean overflow = this.colony.getSpecification().getBoolean(GameOptions.SAVE_PRODUCTION_OVERFLOW);
        List<AbstractGoods> consumption = new ArrayList<>();
        for (AbstractGoods ag : current.getRequiredGoodsList()) {
            AbstractGoods available = find(input, AbstractGoods.matches(ag.getType()));
            if (available != null && ag.getAmount() <= available.getAmount()) {
                int amount = (overflow || ag.getType().isStorable()) ? ag.getAmount() : available.getAmount();
                consumption.add(new AbstractGoods(ag.getType(), amount));
            } else {
                return result;
            }
        }
        result.setConsumption(consumption);
    }
    return result;
}