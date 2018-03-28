private boolean modifiersPresent() {
    synchronized (modifiersLock) {
        return modifiers != null;
    }
}