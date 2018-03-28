public void removeFeatures(FreeColObject fco) {
    FeatureContainer c = fco.getFeatureContainer();
    if (c == null)
        return;
    if (abilitiesPresent() && c.abilitiesPresent()) {
        Set<String> ca = new HashSet<>();
        synchronized (c.abilitiesLock) {
            ca.addAll(c.abilities.keySet());
        }
        synchronized (abilitiesLock) {
            for (String key : ca) {
                Set<Ability> abilitySet = abilities.get(key);
                if (abilitySet == null)
                    continue;
                for (Ability a : new HashSet<>(abilitySet)) {
                    if (a.getSource() == fco)
                        abilitySet.remove(a);
                }
            }
        }
    }
    if (modifiersPresent() && c.modifiersPresent()) {
        Set<String> cm = new HashSet<>();
        synchronized (c.modifiersLock) {
            cm.addAll(c.modifiers.keySet());
        }
        synchronized (modifiersLock) {
            for (String key : cm) {
                Set<Modifier> modifierSet = modifiers.get(key);
                if (modifierSet == null)
                    continue;
                for (Modifier m : new HashSet<>(modifierSet)) {
                    if (m.getSource() == fco)
                        modifierSet.remove(m);
                }
            }
        }
    }
}