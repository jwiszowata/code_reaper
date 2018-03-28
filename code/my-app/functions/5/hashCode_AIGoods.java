public int hashCode() {
    int hash = super.hashCode();
    hash = 37 * hash + Utils.hashCode(this.goods);
    return 37 * hash + Utils.hashCode(this.destination);
}