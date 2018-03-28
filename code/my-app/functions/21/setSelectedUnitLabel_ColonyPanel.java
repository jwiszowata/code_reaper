public void setSelectedUnitLabel(UnitLabel unitLabel) {
    if (selectedUnitLabel != unitLabel) {
        inPortPanel.removePropertyChangeListeners();
        if (selectedUnitLabel != null) {
            selectedUnitLabel.setSelected(false);
            selectedUnitLabel.getUnit().removePropertyChangeListener(this);
        }
        super.setSelectedUnitLabel(unitLabel);
        if (unitLabel == null) {
            cargoPanel.setCarrier(null);
        } else {
            cargoPanel.setCarrier(unitLabel.getUnit());
            unitLabel.setSelected(true);
            unitLabel.getUnit().addPropertyChangeListener(this);
        }
        inPortPanel.addPropertyChangeListeners();
    }
    updateCarrierButtons();
    inPortPanel.revalidate();
    inPortPanel.repaint();
}