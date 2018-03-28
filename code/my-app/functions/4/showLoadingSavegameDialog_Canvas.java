public boolean showLoadingSavegameDialog(boolean publicServer, boolean singlePlayer) {
    loadingSavegameDialog = new LoadingSavegameDialog(freeColClient, frame);
    return showFreeColDialog(loadingSavegameDialog, null);
}