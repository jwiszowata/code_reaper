public boolean importData(JComponent target, Transferable data) {
    JList<TradeRouteStop> stl = TradeRouteInputPanel.this.stopList;
    if (canImport(target, data.getTransferDataFlavors()) && target == stl && data instanceof StopListTransferable) {
        List<TradeRouteStop> stops = ((StopListTransferable) data).getStops();
        DefaultListModel<TradeRouteStop> model = new DefaultListModel<>();
        int index = stl.getMaxSelectionIndex();
        for (TradeRouteStop stop : stops) {
            if (index < 0) {
                model.addElement(stop);
            } else {
                index++;
                model.add(index, stop);
            }
        }
        stl.setModel(model);
        return true;
    }
    return false;
}