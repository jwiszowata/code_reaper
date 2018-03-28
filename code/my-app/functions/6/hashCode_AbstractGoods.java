public int hashCode() {
    int hash = super.hashCode();
    hash = 31 * hash + Utils.hashCode(this.type);
    hash = 31 * hash + this.amount;
    return hash;
}