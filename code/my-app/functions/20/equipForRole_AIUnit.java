public boolean equipForRole(Role role) {
    final Player player = unit.getOwner();
    Location loc = Location.upLoc(unit.getLocation());
    if (!(loc instanceof UnitLocation))
        return false;
    int count = role.getMaximumCount();
    if (count > 0) {
        for (; count > 0; count--) {
            List<AbstractGoods> req = unit.getGoodsDifference(role, count);
            int price = ((UnitLocation) loc).priceGoods(req);
            if (price < 0)
                continue;
            if (player.checkGold(price))
                break;
        }
        if (count <= 0)
            return false;
    }
    return AIMessage.askEquipForRole(this, role, count) && unit.getRole() == role && unit.getRoleCount() == count;
}