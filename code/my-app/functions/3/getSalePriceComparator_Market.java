public <T extends AbstractGoods> Comparator<T> getSalePriceComparator() {
    return Comparator.comparingInt((T t) -> getSalePrice(t.getType(), t.getAmount())).reversed();
}