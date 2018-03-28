public void showClientOptionsDialog() {
    OptionGroup group = null;
    try {
        group = canvas.showClientOptionsDialog();
    } finally {
        if (group != null) {
            resetMenuBar();
            updateMapControls();
        }
    }
    if (!getFreeColClient().isInGame())
        showMainPanel(null);
}