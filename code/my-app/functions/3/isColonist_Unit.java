public boolean isColonist() {
    return this.unitType.hasAbility(Ability.FOUND_COLONY) && owner.hasAbility(Ability.FOUNDS_COLONIES);
}