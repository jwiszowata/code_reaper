private void addChange(TileTypeChange change) {
    if (tileTypeChanges == null)
        tileTypeChanges = new HashMap<>();
    tileTypeChanges.put(change.getFrom(), change);
}