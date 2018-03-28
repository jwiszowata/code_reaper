public boolean isPerson() {
    return (this.unitType == null) ? false : this.unitType.hasAbility(Ability.PERSON);
}