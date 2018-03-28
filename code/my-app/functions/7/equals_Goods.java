public boolean equals(Object o) {
    if (o instanceof Goods) {
        Goods g = (Goods) o;
        return this.location == g.location && super.equals(g);
    }
    return false;
}