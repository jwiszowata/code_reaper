public boolean importData(JComponent target, Transferable data) {
    if (!canImport(target, data.getTransferDataFlavors()))
        return false;
    try {
        CargoLabel label = (CargoLabel) data.getTransferData(DefaultTransferHandler.flavor);
        if (target instanceof CargoPanel) {
            CargoLabel newLabel = new CargoLabel(label.getType());
            TradeRouteInputPanel.this.cargoPanel.add(newLabel);
            TradeRouteInputPanel.this.cargoPanel.revalidate();
            int[] indices = TradeRouteInputPanel.this.stopList.getSelectedIndices();
            for (int index : indices) {
                TradeRouteStop stop = TradeRouteInputPanel.this.stopListModel.get(index);
                stop.addCargo(label.getType());
            }
            TradeRouteInputPanel.this.stopList.revalidate();
            TradeRouteInputPanel.this.stopList.repaint();
        }
        return true;
    } catch (IOException | UnsupportedFlavorException ex) {
        logger.log(Level.WARNING, "CargoHandler import", ex);
    }
    return false;
}