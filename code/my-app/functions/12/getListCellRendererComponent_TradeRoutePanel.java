public Component getListCellRendererComponent(JList list, Object value, int index, boolean selected, boolean focus) {
    Component ret = super.getListCellRendererComponent(list, value, index, selected, focus);
    TradeRoute tradeRoute = (TradeRoute) value;
    String name = tradeRoute.getName();
    Integer n = TradeRoutePanel.this.counts.get(tradeRoute);
    if (n == null || n <= 0) {
        setText(name);
    } else {
        setText(name + "  (" + n + ")");
    }
    return ret;
}