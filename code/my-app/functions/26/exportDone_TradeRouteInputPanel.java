protected void exportDone(JComponent source, Transferable data, int action) {
    try {
        CargoLabel label = (CargoLabel) data.getTransferData(DefaultTransferHandler.flavor);
        if (source.getParent() instanceof CargoPanel) {
            TradeRouteInputPanel.this.cargoPanel.remove(label);
            int[] indices = TradeRouteInputPanel.this.stopList.getSelectedIndices();
            for (int stopIndex : indices) {
                TradeRouteStop stop = TradeRouteInputPanel.this.stopListModel.get(stopIndex);
                List<GoodsType> cargo = new ArrayList<>(stop.getCargo());
                for (int index = 0; index < cargo.size(); index++) {
                    if (cargo.get(index) == label.getType()) {
                        cargo.remove(index);
                        break;
                    }
                }
                stop.setCargo(cargo);
            }
            TradeRouteInputPanel.this.stopList.revalidate();
            TradeRouteInputPanel.this.stopList.repaint();
            TradeRouteInputPanel.this.cargoPanel.revalidate();
            TradeRouteInputPanel.this.cargoPanel.repaint();
        }
    } catch (IOException | UnsupportedFlavorException ex) {
        logger.log(Level.WARNING, "CargoHandler export", ex);
    }
}