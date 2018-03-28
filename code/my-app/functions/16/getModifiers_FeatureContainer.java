public Stream<Modifier> getModifiers(String id, FreeColSpecObjectType fcgot, Turn turn) {
    if (!modifiersPresent())
        return Stream.<Modifier>empty();
    Set<Modifier> mset = new HashSet<>();
    synchronized (modifiersLock) {
        if (id == null) {
            for (Set<Modifier> ms : modifiers.values()) mset.addAll(ms);
        } else {
            Set<Modifier> ms = modifiers.get(id);
            if (ms != null)
                mset.addAll(ms);
        }
    }
    removeInPlace(mset, m -> !m.appliesTo(fcgot, turn));
    return (mset.isEmpty()) ? Stream.<Modifier>empty() : mset.stream();
}