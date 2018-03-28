public String getLastSaleString(Location where, GoodsType what) {
    LastSale data = getLastSale(where, what);
    return (data == null) ? null : String.valueOf(data.getPrice());
}