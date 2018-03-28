private void savePosition(Component comp, Point position) {
    try {
        if (!freeColClient.getClientOptions().getBoolean(ClientOptions.REMEMBER_PANEL_POSITIONS))
            return;
    } catch (Exception e) {
    }
    String className = comp.getClass().getName();
    saveInteger(className, ".x", position.x);
    saveInteger(className, ".y", position.y);
}