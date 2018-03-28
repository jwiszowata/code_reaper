private Dimension getSavedSize(Component comp) {
    final ClientOptions co = freeColClient.getClientOptions();
    if (co == null)
        return null;
    try {
        if (!co.getBoolean(ClientOptions.REMEMBER_PANEL_SIZES)) {
            return null;
        }
    } catch (Exception e) {
    }
    return co.getPanelSize(comp.getClass().getName());
}