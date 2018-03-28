public boolean equipUnitForRole(Unit unit, Role role, int roleCount) {
    return ask(unit.getGame(), new EquipForRoleMessage(unit, role, roleCount));
}