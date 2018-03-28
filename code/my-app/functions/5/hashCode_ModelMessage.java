public int hashCode() {
    int hash = super.hashCode();
    hash = 37 * hash + sourceId.hashCode();
    return 37 * hash + messageType.ordinal();
}