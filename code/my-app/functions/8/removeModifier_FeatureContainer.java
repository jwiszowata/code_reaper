public Modifier removeModifier(Modifier modifier) {
    if (modifier == null || !modifiersPresent())
        return null;
    synchronized (modifiersLock) {
        Set<Modifier> modifierSet = modifiers.get(modifier.getId());
        return (modifierSet == null || !modifierSet.remove(modifier)) ? null : modifier;
    }
}