private void newRoute() {
    final Player player = getMyPlayer();
    final Unit u = this.unit;
    final TradeRoute newRoute = igc().newTradeRoute(player);
    getGUI().showTradeRouteInputPanel(newRoute, () -> {
        StringTemplate template = null;
        String name = newRoute.getName();
        if (name == null) {
            igc().deleteTradeRoute(newRoute);
            updateList(null);
        } else if ((template = newRoute.verify()) != null && (template = newRoute.verifyUniqueName()) != null) {
            updateList(null);
            getGUI().showInformationMessage(template);
        } else {
            igc().updateTradeRoute(newRoute);
            if (u != null)
                igc().assignTradeRoute(u, newRoute);
            updateList(newRoute);
        }
    });
}