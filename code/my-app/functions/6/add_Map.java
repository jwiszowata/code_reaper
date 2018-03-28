public boolean add(Locatable locatable) {
    if (locatable instanceof Unit) {
        throw new RuntimeException("Disabled Map.add(Unit)");
    }
    return false;
}