protected void removePropertyChangeListeners() {
    if (building != null) {
        building.removePropertyChangeListener(this);
    }
}