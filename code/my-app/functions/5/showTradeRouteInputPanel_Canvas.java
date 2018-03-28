public void showTradeRouteInputPanel(TradeRoute newRoute, Runnable callBack) {
    FreeColPanel panel = new TradeRouteInputPanel(freeColClient, newRoute);
    panel.addClosingCallback(callBack);
    showSubPanel(panel, null, true);
}