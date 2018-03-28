private void removePropertyChangeListeners() {
    final Colony colony = getColony();
    if (colony != null) {
        colony.getGoodsContainer().removePropertyChangeListener(this);
    }
}