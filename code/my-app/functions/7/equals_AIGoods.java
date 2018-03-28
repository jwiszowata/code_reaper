public boolean equals(Object other) {
    if (other instanceof AIGoods) {
        AIGoods oa = (AIGoods) other;
        return super.equals(oa) && Utils.equals(this.goods, oa.goods) && Utils.equals(this.destination, oa.destination);
    }
    return false;
}