public int hashCode() {
    int hash = super.hashCode();
    hash = 37 * hash + Utils.hashCode(colony);
    hash = 37 * hash + Utils.hashCode(path);
    hash = 37 * hash + Utils.hashCode(score);
    hash = 37 * hash + Utils.hashCode(disembarkTile);
    return 37 * hash + Utils.hashCode(entry);
}