public void initialize() {
    if (ColonyPanel.this.isEditable()) {
        cleanup();
        addMouseListener(pressListener);
        addMouseListener(releaseListener);
        setTransferHandler(defaultTransferHandler);
        addPropertyChangeListeners();
    }
}