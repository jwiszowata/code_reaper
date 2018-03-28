public int hashCode() {
    int hash = super.hashCode();
    hash = 37 * hash + Utils.hashCode(this.goodsType);
    return 37 * hash + this.amountRequested;
}