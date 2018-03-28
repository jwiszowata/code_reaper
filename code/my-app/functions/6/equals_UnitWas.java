public boolean equals(Object other) {
    if (other instanceof UnitWas) {
        return this.compareTo((UnitWas) other) == 0;
    }
    return super.equals(other);
}