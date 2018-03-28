public int hashCode() {
    int hash = super.hashCode();
    hash = 37 * hash + Utils.hashCode(this.destination);
    return 37 * hash + Utils.hashCode(this.transportable);
}