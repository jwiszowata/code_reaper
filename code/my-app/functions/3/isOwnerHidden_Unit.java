public boolean isOwnerHidden() {
    return (this.unitType == null) ? false : this.unitType.hasAbility(Ability.PIRACY);
}