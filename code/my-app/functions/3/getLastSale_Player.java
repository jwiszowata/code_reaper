public LastSale getLastSale(Location where, GoodsType what) {
    return (lastSales == null) ? null : lastSales.get(LastSale.makeKey(where, what));
}