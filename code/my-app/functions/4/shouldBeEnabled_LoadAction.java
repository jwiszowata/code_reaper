protected boolean shouldBeEnabled() {
    final Unit carrier = getGUI().getActiveUnit();
    return super.shouldBeEnabled() && carrier != null && carrier.isCarrier() && carrier.hasSpaceLeft();
}