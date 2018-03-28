public int hashCode() {
    int hash = super.hashCode();
    hash = 37 * hash + Utils.hashCode(this.source);
    return 37 * hash + Utils.hashCode(this.destination);
}