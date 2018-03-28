protected void addPropertyChangeListeners() {
    if (carrier != null) {
        carrier.addPropertyChangeListener(Unit.CARGO_CHANGE, this);
        carrier.getGoodsContainer().addPropertyChangeListener(this);
    }
}