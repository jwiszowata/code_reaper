public void setEnabled(boolean enabled) {
    super.setEnabled(enabled);
    Component[] components = getComponents();
    for (Component component : components) {
        component.setEnabled(enabled);
    }
    if (singlePlayerGame && enabled) {
        readyBox.setEnabled(false);
    }
    if (enabled) {
        start.setEnabled(getFreeColClient().isAdmin());
    }
    gameOptions.setEnabled(enabled);
}