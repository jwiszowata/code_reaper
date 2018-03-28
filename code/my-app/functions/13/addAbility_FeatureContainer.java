public boolean addAbility(Ability ability) {
    if (ability == null)
        return false;
    requireAbilities();
    synchronized (abilitiesLock) {
        Set<Ability> abilitySet = abilities.get(ability.getId());
        if (abilitySet == null) {
            abilitySet = new HashSet<>();
            abilities.put(ability.getId(), abilitySet);
        }
        return abilitySet.add(ability);
    }
}