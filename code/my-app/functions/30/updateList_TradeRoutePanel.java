private void updateList(TradeRoute selectRoute) {
    final Player player = getMyPlayer();
    List<TradeRoute> routes = new ArrayList<>();
    for (TradeRoute tr : player.getTradeRoutes()) {
        StringTemplate st = tr.verify();
        if (st == null) {
            routes.add(tr);
        } else {
            igc().deleteTradeRoute(tr);
            logger.warning("Dropped trade route: " + Messages.message(st));
        }
    }
    routes.sort(tradeRouteComparator);
    this.counts.clear();
    for (Unit u : player.getUnitList()) {
        TradeRoute tradeRoute = u.getTradeRoute();
        if (tradeRoute != null && routes.contains(tradeRoute)) {
            Integer i = counts.get(tradeRoute);
            int value = (i == null) ? 0 : i;
            counts.put(tradeRoute, value + 1);
        }
    }
    this.listModel.clear();
    for (TradeRoute route : routes) {
        this.listModel.addElement(route);
    }
    if (selectRoute != null && this.tradeRoutes != null) {
        this.tradeRoutes.setSelectedValue(selectRoute, true);
    }
}