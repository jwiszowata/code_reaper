public void removeAbilities(String id) {
    if (!abilitiesPresent())
        return;
    synchronized (abilitiesLock) {
        abilities.remove(id);
    }
}