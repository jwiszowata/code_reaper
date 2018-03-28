private void requireAbilities() {
    synchronized (abilitiesLock) {
        if (abilities == null)
            abilities = new HashMap<>();
    }
}