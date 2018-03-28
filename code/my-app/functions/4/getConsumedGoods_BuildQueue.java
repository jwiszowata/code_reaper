public List<AbstractGoods> getConsumedGoods() {
    T current = getCurrentlyBuilding();
    return (current == null) ? Collections.<AbstractGoods>emptyList() : current.getRequiredGoodsList();
}