public boolean onClosingErrorPanel(Runnable callback) {
    ErrorPanel ep = getExistingFreeColPanel(ErrorPanel.class);
    if (ep == null)
        return false;
    ep.addClosingCallback(callback);
    return true;
}