public int hashCode() {
    int hash = super.hashCode();
    return 31 * hash + Utils.hashCode(this.value);
}