private void addMouseListeners() {
    if (isEditable()) {
        cargoPanel.addMouseListener(releaseListener);
        inPortPanel.addMouseListener(releaseListener);
        outsideColonyPanel.addMouseListener(releaseListener);
        warehousePanel.addMouseListener(releaseListener);
    }
}