private void csCaptureEquip(Unit winner, Unit loser, ChangeSet cs) {
    Role role = loser.getRole();
    csLoseEquip(winner, loser, cs);
    csCaptureEquipment(winner, loser, role, cs);
}