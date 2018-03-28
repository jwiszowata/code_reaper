protected boolean shouldBeEnabled() {
    return super.shouldBeEnabled() && getGUI().canZoomOutMapControls();
}