public int hashCode() {
    int hash = super.hashCode();
    hash = 37 * hash + x;
    hash = 37 * hash + y;
    return 37 * hash + image.hashCode();
}