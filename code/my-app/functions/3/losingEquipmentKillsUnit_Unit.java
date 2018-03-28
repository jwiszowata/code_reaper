public boolean losingEquipmentKillsUnit() {
    return hasAbility(Ability.DISPOSE_ON_ALL_EQUIPMENT_LOST) && getRole().getDowngrade() == null;
}