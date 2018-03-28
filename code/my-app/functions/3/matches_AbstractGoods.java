public static final Predicate<? super AbstractGoods> matches(final GoodsType key) {
    return matchKey(key, AbstractGoods::getType);
}