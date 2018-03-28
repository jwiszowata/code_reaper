public boolean equals(Object other) {
    if (other instanceof TargetTuple) {
        return this.compareTo((TargetTuple) other) == 0;
    }
    return super.equals(other);
}