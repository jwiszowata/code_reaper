public int getIndex(TradeRouteStop stop) {
    int i = 0;
    for (TradeRouteStop trs : this.stops) {
        if (trs == stop)
            return i;
        i++;
    }
    return -1;
}