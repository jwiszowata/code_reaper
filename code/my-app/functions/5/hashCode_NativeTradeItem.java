public int hashCode() {
    int hash = super.hashCode();
    hash = 37 * hash + this.price;
    return 37 * hash + this.haggleCount;
}