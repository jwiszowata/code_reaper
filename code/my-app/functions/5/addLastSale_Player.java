public void addLastSale(LastSale sale) {
    if (lastSales == null)
        lastSales = new HashMap<>();
    lastSales.put(sale.getId(), sale);
}