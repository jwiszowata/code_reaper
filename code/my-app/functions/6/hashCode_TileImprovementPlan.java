public int hashCode() {
    int hash = super.hashCode();
    hash = 37 * hash + Utils.hashCode(this.type);
    hash = 37 * hash + Utils.hashCode(this.target);
    return 37 * hash + Utils.hashCode(this.pioneer);
}