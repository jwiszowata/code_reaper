public void valueChanged(ListSelectionEvent e) {
    if (e.getValueIsAdjusting())
        return;
    int[] idx = this.stopList.getSelectedIndices();
    if (idx.length > 0) {
        TradeRouteStop stop = this.stopListModel.get(idx[0]);
        this.cargoPanel.initialize(stop);
        this.goodsPanel.setEnabled(true);
    } else {
        this.goodsPanel.setEnabled(false);
    }
    updateButtons();
}