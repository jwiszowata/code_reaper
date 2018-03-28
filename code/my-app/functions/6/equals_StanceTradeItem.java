public boolean equals(Object other) {
    if (other instanceof StanceTradeItem) {
        return this.stance == ((StanceTradeItem) other).stance && super.equals(other);
    }
    return false;
}