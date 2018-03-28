public Location getEntryLocation() {
    if (entryLocation == null) {
        entryLocation = owner.getEntryLocation();
    }
    return entryLocation;
}