public List<TradeRouteStop> getCurrentStops() {
    if (validateCurrentStop() < 0)
        return null;
    List<TradeRouteStop> stops = new ArrayList<TradeRouteStop>(getTradeRoute().getStops());
    rotate(stops, currentStop);
    return stops;
}