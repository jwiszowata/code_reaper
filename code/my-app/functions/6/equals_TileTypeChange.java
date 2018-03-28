public boolean equals(Object other) {
    if (other instanceof TileTypeChange) {
        return this.compareTo((TileTypeChange) other) == 0;
    }
    return super.equals(other);
}