public Location up() {
    return (hasSettlement()) ? getSettlement() : this;
}