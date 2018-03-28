public int hashCode() {
    int hash = super.hashCode();
    hash = 37 * hash + Utils.hashCode(image);
    return 37 * hash + index;
}