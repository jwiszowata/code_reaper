protected boolean shouldBeEnabled() {
    if (freeColClient.isMapEditor())
        return true;
    if (!freeColClient.canSaveCurrentGame())
        return false;
    return !getGUI().isShowingSubPanel();
}