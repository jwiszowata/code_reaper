public List<TradeRouteStop> getStopSublist(TradeRouteStop start, TradeRouteStop end) {
    int i0 = getIndex(start), in = getIndex(end);
    if (i0 < 0 || in < 0)
        return null;
    List<TradeRouteStop> result = new ArrayList<>();
    while (i0 != in) {
        result.add(this.stops.get(i0));
        if (++i0 >= this.stops.size())
            i0 = 0;
    }
    return result;
}