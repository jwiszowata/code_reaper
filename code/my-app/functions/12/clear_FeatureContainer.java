public void clear() {
    if (abilitiesPresent()) {
        synchronized (abilitiesLock) {
            abilities.clear();
        }
    }
    if (modifiersPresent()) {
        synchronized (modifiersLock) {
            modifiers.clear();
        }
    }
}