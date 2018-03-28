public boolean equals(Object other) {
    if (other instanceof GoodsTradeItem) {
        return Utils.equals(this.goods, ((GoodsTradeItem) other).goods) && super.equals(other);
    }
    return false;
}