public int getUnitPrice(UnitType unitType) {
    Integer price = unitPrices.get(unitType);
    return (price != null) ? price : unitType.getPrice();
}