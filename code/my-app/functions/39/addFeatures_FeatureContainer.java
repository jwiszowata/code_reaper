public void addFeatures(FreeColObject fco) {
    FeatureContainer c = fco.getFeatureContainer();
    if (c == null)
        return;
    if (c.abilitiesPresent()) {
        requireAbilities();
        HashMap<String, Set<Ability>> ca;
        synchronized (c.abilitiesLock) {
            ca = new HashMap<>(c.abilities);
        }
        synchronized (abilitiesLock) {
            forEachMapEntry(ca, e -> {
                Set<Ability> abilitySet = abilities.get(e.getKey());
                if (abilitySet == null) {
                    abilitySet = new HashSet<>();
                    abilities.put(e.getKey(), abilitySet);
                }
                abilitySet.addAll(e.getValue());
            });
        }
    }
    if (c.modifiersPresent()) {
        requireModifiers();
        HashMap<String, Set<Modifier>> cm;
        synchronized (c.modifiersLock) {
            cm = new HashMap<>(c.modifiers);
        }
        synchronized (modifiersLock) {
            forEachMapEntry(cm, e -> {
                Set<Modifier> modifierSet = modifiers.get(e.getKey());
                if (modifierSet == null) {
                    modifierSet = new HashSet<>();
                    modifiers.put(e.getKey(), modifierSet);
                }
                modifierSet.addAll(e.getValue());
            });
        }
    }
}