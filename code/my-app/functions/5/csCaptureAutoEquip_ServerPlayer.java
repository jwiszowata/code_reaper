private void csCaptureAutoEquip(Unit attacker, Unit defender, ChangeSet cs) {
    Role role = defender.getAutomaticRole();
    csLoseAutoEquip(attacker, defender, cs);
    csCaptureEquipment(attacker, defender, role, cs);
}