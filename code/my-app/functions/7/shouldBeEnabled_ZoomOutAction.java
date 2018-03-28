protected boolean shouldBeEnabled() {
    if (!super.shouldBeEnabled())
        return false;
    if (!getGUI().isMapboardActionsEnabled())
        return false;
    return getGUI().canZoomOutMap();
}