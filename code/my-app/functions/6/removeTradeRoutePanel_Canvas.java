public void removeTradeRoutePanel(TradeRoutePanel panel) {
    remove(panel);
    TradeRouteInputPanel trip = getExistingFreeColPanel(TradeRouteInputPanel.class);
    if (trip != null)
        trip.cancelTradeRoute();
}