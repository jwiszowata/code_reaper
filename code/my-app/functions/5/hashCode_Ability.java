public int hashCode() {
    int hash = super.hashCode();
    hash += (value) ? 1 : 0;
    return hash;
}