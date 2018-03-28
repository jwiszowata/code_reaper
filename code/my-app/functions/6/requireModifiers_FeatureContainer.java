private synchronized void requireModifiers() {
    synchronized (modifiersLock) {
        if (modifiers == null)
            modifiers = new HashMap<>();
    }
}