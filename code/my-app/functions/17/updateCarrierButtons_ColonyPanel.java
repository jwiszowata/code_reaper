private void updateCarrierButtons() {
    final Colony colony = getColony();
    unloadButton.setEnabled(false);
    fillButton.setEnabled(false);
    if (isEditable() && selectedUnitLabel != null) {
        Unit unit = selectedUnitLabel.getUnit();
        if (unit != null && unit.isCarrier() && unit.hasCargo()) {
            unloadButton.setEnabled(true);
            for (Goods goods : unit.getCompactGoodsList()) {
                if (colony.getGoodsCount(goods.getType()) > 0) {
                    fillButton.setEnabled(true);
                    break;
                }
            }
        }
    }
}