private Point getSavedPosition(Component comp) {
    final ClientOptions co = freeColClient.getClientOptions();
    if (co == null)
        return null;
    try {
        if (!co.getBoolean(ClientOptions.REMEMBER_PANEL_POSITIONS)) {
            return null;
        }
    } catch (Exception e) {
    }
    return co.getPanelPosition(comp.getClass().getName());
}