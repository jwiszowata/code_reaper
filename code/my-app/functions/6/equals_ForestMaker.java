public boolean equals(Object other) {
    if (other instanceof ImageLocation) {
        return this.compareTo((ImageLocation) other) == 0;
    }
    return super.equals(other);
}