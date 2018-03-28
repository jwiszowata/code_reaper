public int hashCode() {
    int hash = super.hashCode();
    return 37 * hash + Utils.hashCode(this.victim);
}