private void addPropertyChangeListeners() {
    final Colony colony = getColony();
    if (colony != null) {
        colony.addPropertyChangeListener(this);
        colony.getGoodsContainer().addPropertyChangeListener(this);
        colony.getTile().addPropertyChangeListener(this);
    }
}