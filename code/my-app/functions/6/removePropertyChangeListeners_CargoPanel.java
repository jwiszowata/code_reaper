protected void removePropertyChangeListeners() {
    if (carrier != null) {
        carrier.removePropertyChangeListener(Unit.CARGO_CHANGE, this);
        carrier.getGoodsContainer().removePropertyChangeListener(this);
    }
}