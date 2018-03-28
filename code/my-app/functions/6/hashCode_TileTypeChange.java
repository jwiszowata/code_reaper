public int hashCode() {
    int hash = super.hashCode();
    hash = 37 * hash + Utils.hashCode(this.from);
    hash = 37 * hash + Utils.hashCode(this.to);
    return 37 * hash + Utils.hashCode(this.production);
}