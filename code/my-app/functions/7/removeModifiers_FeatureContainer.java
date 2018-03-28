public void removeModifiers(String id) {
    if (!modifiersPresent())
        return;
    synchronized (modifiersLock) {
        modifiers.remove(id);
    }
}