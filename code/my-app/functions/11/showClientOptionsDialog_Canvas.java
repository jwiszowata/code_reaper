public OptionGroup showClientOptionsDialog() {
    ClientOptionsDialog dialog = new ClientOptionsDialog(freeColClient, frame);
    OptionGroup group = null;
    clientOptionsDialogShowing = true;
    try {
        group = showFreeColDialog(dialog, null);
    } finally {
        clientOptionsDialogShowing = false;
    }
    return group;
}