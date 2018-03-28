public void initialize() {
    if (ColonyPanel.this.isEditable()) {
        super.initialize();
        addMouseListener(releaseListener);
        addMouseListener(buildQueueListener);
        setTransferHandler(defaultTransferHandler);
    }
}