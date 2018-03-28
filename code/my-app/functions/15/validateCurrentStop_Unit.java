public int validateCurrentStop() {
    if (tradeRoute == null) {
        currentStop = -1;
    } else {
        List<TradeRouteStop> stops = tradeRoute.getStops();
        if (stops == null || stops.isEmpty()) {
            currentStop = -1;
        } else {
            if (currentStop < 0 || currentStop >= stops.size()) {
                currentStop = 0;
            }
        }
    }
    return currentStop;
}