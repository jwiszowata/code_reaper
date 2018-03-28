public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o instanceof AbstractGoods) {
        AbstractGoods ag = (AbstractGoods) o;
        return type == ag.type && amount == ag.amount;
    }
    return false;
}