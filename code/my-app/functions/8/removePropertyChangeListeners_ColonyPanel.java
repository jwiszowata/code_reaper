private void removePropertyChangeListeners() {
    final Colony colony = getColony();
    if (colony != null) {
        colony.removePropertyChangeListener(this);
        colony.getGoodsContainer().removePropertyChangeListener(this);
        colony.getTile().removePropertyChangeListener(this);
    }
}