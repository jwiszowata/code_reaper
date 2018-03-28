public TradeRouteStop getStop() {
    return (validateCurrentStop() < 0) ? null : getTradeRoute().getStops().get(currentStop);
}