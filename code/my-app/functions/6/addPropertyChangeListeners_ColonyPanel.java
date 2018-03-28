private void addPropertyChangeListeners() {
    final Colony colony = getColony();
    if (colony != null) {
        colony.getGoodsContainer().addPropertyChangeListener(this);
    }
}