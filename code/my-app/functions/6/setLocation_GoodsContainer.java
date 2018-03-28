public void setLocation(Location location) {
    if (location == null) {
        throw new IllegalArgumentException("Null GoodsContainer Location.");
    }
    this.parent = location;
}