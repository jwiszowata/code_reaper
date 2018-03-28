public boolean addModifier(Modifier modifier) {
    if (modifier == null)
        return false;
    requireModifiers();
    synchronized (modifiersLock) {
        Set<Modifier> modifierSet = modifiers.get(modifier.getId());
        if (modifierSet == null) {
            modifierSet = new HashSet<>();
            modifiers.put(modifier.getId(), modifierSet);
        }
        return modifierSet.add(modifier);
    }
}