public void showTradeRoutePanel(Unit unit) {
    showFreeColPanel(new TradeRoutePanel(freeColClient, unit), (unit == null) ? null : unit.getTile(), true);
}