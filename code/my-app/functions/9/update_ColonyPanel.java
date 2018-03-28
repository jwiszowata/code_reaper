public void update() {
    super.update();
    if (ColonyPanel.this.isEditable()) {
        for (UnitLabel unitLabel : getUnitLabels()) {
            unitLabel.setTransferHandler(defaultTransferHandler);
            unitLabel.addMouseListener(pressListener);
        }
    }
}