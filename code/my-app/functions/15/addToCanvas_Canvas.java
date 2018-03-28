private void addToCanvas(Component comp, Integer i) {
    if (statusPanel.isVisible()) {
        if (comp == statusPanel)
            return;
        if (!(comp instanceof JMenuItem))
            removeFromCanvas(statusPanel);
    }
    if (i == null)
        i = JLayeredPane.DEFAULT_LAYER;
    try {
        super.add(comp, i);
    } catch (Exception e) {
        logger.log(Level.WARNING, "addToCanvas(" + comp + ", " + i + ") failed.", e);
    }
}