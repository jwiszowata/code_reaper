public String getStockadeKey() {
    Building stockade = getStockade();
    return (stockade == null) ? null : stockade.getType().getSuffix();
}