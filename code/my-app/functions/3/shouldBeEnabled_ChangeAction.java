protected boolean shouldBeEnabled() {
    return super.shouldBeEnabled() && getGUI().getActiveUnit().hasTile();
}