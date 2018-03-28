protected Transferable createTransferable(JComponent c) {
    JList list = (JList) c;
    DefaultListModel model = (DefaultListModel) list.getModel();
    List<TradeRouteStop> stops = new ArrayList<>();
    for (int index : list.getSelectedIndices()) {
        stops.add((TradeRouteStop) model.get(index));
    }
    return new StopListTransferable(stops);
}