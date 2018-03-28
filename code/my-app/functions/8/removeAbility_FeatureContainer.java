public Ability removeAbility(Ability ability) {
    if (ability == null || !abilitiesPresent())
        return null;
    synchronized (abilitiesLock) {
        Set<Ability> abilitySet = abilities.get(ability.getId());
        return (abilitySet == null || !abilitySet.remove(ability)) ? null : ability;
    }
}