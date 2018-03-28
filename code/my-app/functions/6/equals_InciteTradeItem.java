public boolean equals(Object other) {
    if (other instanceof InciteTradeItem) {
        return Utils.equals(this.victim, ((InciteTradeItem) other).victim) && super.equals(other);
    }
    return false;
}