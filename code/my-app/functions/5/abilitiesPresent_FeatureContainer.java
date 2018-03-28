private boolean abilitiesPresent() {
    synchronized (abilitiesLock) {
        return abilities != null;
    }
}