public boolean equipForRole(Unit unit, Role role, int roleCount) {
    if (!unit.roleIsAvailable(role))
        return false;
    List<AbstractGoods> required = unit.getGoodsDifference(role, roleCount);
    if (priceGoods(required) < 0)
        return false;
    for (AbstractGoods ag : required) {
        addGoods(ag.getType(), -ag.getAmount());
    }
    unit.changeRole(role, roleCount);
    return true;
}