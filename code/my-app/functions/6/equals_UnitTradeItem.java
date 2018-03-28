public boolean equals(Object other) {
    if (other instanceof UnitTradeItem) {
        return Utils.equals(this.unit, ((UnitTradeItem) other).unit) && super.equals(other);
    }
    return false;
}