public boolean losingEquipmentDemotesUnit() {
    return hasAbility(Ability.DEMOTE_ON_ALL_EQUIPMENT_LOST) && getRole().getDowngrade() == null;
}