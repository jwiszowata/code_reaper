public boolean equals(Object other) {
    if (other instanceof SortableImage) {
        return this.compareTo((SortableImage) other) == 0;
    }
    return super.equals(other);
}