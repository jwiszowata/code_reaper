private void saveSize(Component comp, Dimension size) {
    try {
        if (!freeColClient.getClientOptions().getBoolean(ClientOptions.REMEMBER_PANEL_SIZES))
            return;
    } catch (Exception e) {
    }
    String className = comp.getClass().getName();
    saveInteger(className, ".w", size.width);
    saveInteger(className, ".h", size.height);
}