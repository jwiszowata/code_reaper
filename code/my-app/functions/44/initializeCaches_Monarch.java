private void initializeCaches() {
    if (navalTypes != null)
        return;
    final Specification spec = getSpecification();
    navalTypes = new ArrayList<>();
    bombardTypes = new ArrayList<>();
    landTypes = new ArrayList<>();
    mercenaryTypes = new ArrayList<>();
    navalREFUnitTypes = spec.getREFUnitTypes(true);
    landREFUnitTypes = spec.getREFUnitTypes(false);
    for (UnitType unitType : spec.getUnitTypeList()) {
        if (unitType.hasAbility(Ability.SUPPORT_UNIT)) {
            if (unitType.hasAbility(Ability.NAVAL_UNIT)) {
                navalTypes.add(unitType);
            } else if (unitType.hasAbility(Ability.BOMBARD)) {
                bombardTypes.add(unitType);
            } else if (unitType.hasAbility(Ability.CAN_BE_EQUIPPED)) {
                landTypes.add(unitType);
            }
        }
        if (unitType.hasAbility(Ability.MERCENARY_UNIT)) {
            mercenaryTypes.add(unitType);
        }
    }
    for (Role r : spec.getMilitaryRolesList()) {
        boolean ok = r.isAvailableTo(player, first(landTypes));
        boolean armed = r.hasAbility(Ability.ARMED);
        boolean mounted = r.hasAbility(Ability.MOUNTED);
        boolean ref = r.requiresAbility(Ability.REF_UNIT);
        if (armed && mounted) {
            if (ok && !ref && mountedRole == null) {
                mountedRole = r;
            } else if (!ok && ref && refMountedRole == null) {
                refMountedRole = r;
            }
        } else if (armed && !mounted) {
            if (ok && !ref && armedRole == null) {
                armedRole = r;
            } else if (!ok && ref && refArmedRole == null) {
                refArmedRole = r;
            }
        }
    }
}