public StringTemplate getLabel(UnitLabelType ult) {
    final UnitType type = getType();
    final Role role = getRole();
    final Player owner = getOwner();
    if (type == null || role == null || owner == null) {
        return null;
    }
    switch(ult) {
        case PLAIN:
            return Messages.getUnitLabel(getName(), type.getId(), 1, null, role.getId(), null);
        case NATIONAL:
            if (role.getMaximumCount() > 1) {
            } else {
                return Messages.getUnitLabel(getName(), type.getId(), 1, owner.getNationId(), role.getId(), null);
            }
        case FULL:
            StringTemplate extra = null;
            if (role.isDefaultRole()) {
                if (canCarryTreasure()) {
                    extra = StringTemplate.template("goldAmount").addAmount("%amount%", getTreasureAmount());
                } else {
                    boolean noEquipment = false;
                    List<Role> expertRoles = type.getExpertRoles();
                    for (Role someRole : expertRoles) {
                        String key = someRole.getId() + ".noequipment";
                        if (Messages.containsKey(key)) {
                            extra = StringTemplate.key(key);
                            break;
                        }
                    }
                }
            } else {
                String equipmentKey = role.getId() + ".equipment";
                if (Messages.containsKey(equipmentKey)) {
                    extra = AbstractGoods.getLabel(equipmentKey, 1);
                } else {
                    List<AbstractGoods> requiredGoods = role.getRequiredGoodsList(getRoleCount());
                    boolean first = true;
                    extra = StringTemplate.label("");
                    for (AbstractGoods ag : requiredGoods) {
                        if (first)
                            first = false;
                        else
                            extra.addName(" ");
                        extra.addStringTemplate(ag.getLabel());
                    }
                }
            }
            return Messages.getUnitLabel(getName(), type.getId(), 1, owner.getNationId(), role.getId(), extra);
        default:
            break;
    }
    return null;
}