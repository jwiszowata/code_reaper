public List<AbstractGoods> getSortedPotential(Unit unit) {
    return getSortedPotential(unit.getType(), unit.getOwner());
}