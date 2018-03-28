private void updateDescriptionLabel(UnitLabel unitLabel) {
    String tileMsg = Messages.message(this.colonyTile.getLabel());
    if (unitLabel == null) {
        setToolTipText(tileMsg);
    } else {
        final Unit unit = unitLabel.getUnit();
        unitLabel.setDescriptionLabel(tileMsg + " [" + unit.getDescription(Unit.UnitLabelType.NATIONAL) + "]");
    }
}