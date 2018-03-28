public void setEntryLocation(Location entryLocation) {
    this.entryLocation = entryLocation;
    if (entryLocation != null) {
        owner.setEntryLocation(entryLocation);
    }
}