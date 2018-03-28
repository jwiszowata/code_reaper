public boolean equals(Object other) {
    if (other instanceof GoldTradeItem) {
        return this.gold == ((GoldTradeItem) other).gold && super.equals(other);
    }
    return false;
}