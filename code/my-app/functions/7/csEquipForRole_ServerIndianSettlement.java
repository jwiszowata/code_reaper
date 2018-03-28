public boolean csEquipForRole(Unit unit, Role role, int roleCount, Random random, ChangeSet cs) {
    boolean ret = equipForRole(unit, role, roleCount);
    if (ret) {
        cs.add(See.only((ServerPlayer) getOwner()), getTile());
    }
    return ret;
}