private void removePropertyChangeListeners() {
    if (this.colonyTile != null) {
        this.colonyTile.removePropertyChangeListener(this);
    }
}