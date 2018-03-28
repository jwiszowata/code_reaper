public int getPrice(AbstractUnit au) {
    final Specification spec = getSpecification();
    final UnitType unitType = au.getType(spec);
    if (!unitType.hasPrice())
        return INFINITY;
    return au.getNumber() * (getEurope().getUnitPrice(unitType) + au.getRole(spec).getRequiredGoodsPrice(getMarket()));
}