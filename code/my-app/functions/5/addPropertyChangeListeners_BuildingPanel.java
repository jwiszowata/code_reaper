protected void addPropertyChangeListeners() {
    if (building != null) {
        building.addPropertyChangeListener(this);
    }
}