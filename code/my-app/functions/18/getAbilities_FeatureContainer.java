public Stream<Ability> getAbilities(String id, FreeColSpecObjectType fcgot, Turn turn) {
    Set<Ability> result = new HashSet<>();
    if (abilitiesPresent()) {
        synchronized (abilitiesLock) {
            if (id == null) {
                for (Set<Ability> aset : abilities.values()) {
                    result.addAll(aset);
                }
            } else {
                Set<Ability> aset = abilities.get(id);
                if (aset != null)
                    result.addAll(aset);
            }
        }
        removeInPlace(result, a -> !a.appliesTo(fcgot, turn));
    }
    return result.stream();
}