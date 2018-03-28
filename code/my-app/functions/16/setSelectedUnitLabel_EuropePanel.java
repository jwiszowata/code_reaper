public void setSelectedUnitLabel(UnitLabel unitLabel) {
    if (selectedUnitLabel != unitLabel) {
        if (selectedUnitLabel != null) {
            selectedUnitLabel.setSelected(false);
        }
        selectedUnitLabel = unitLabel;
        if (unitLabel == null) {
            cargoPanel.setCarrier(null);
        } else {
            cargoPanel.setCarrier(unitLabel.getUnit());
            unitLabel.setSelected(true);
        }
    }
    inPortPanel.revalidate();
    inPortPanel.repaint();
}