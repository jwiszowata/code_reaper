public int compareTo(FreeColObject other) {
    int cmp = 0;
    if (other instanceof BuildingType) {
        BuildingType bt = (BuildingType) other;
        cmp = getIndex() - bt.getIndex();
    }
    if (cmp == 0)
        cmp = super.compareTo(other);
    return cmp;
}