public int getCost(Unit unit, Location oldLocation, Location newLocation, int movesLeft) {
    for (int i = 0; i < costDeciders.length; i++) {
        int cost = costDeciders[i].getCost(unit, oldLocation, newLocation, movesLeft);
        if (cost == ILLEGAL_MOVE || cost == Map.INFINITY) {
            index = i;
            return ILLEGAL_MOVE;
        }
        if (cost > ret) {
            index = i;
            ret = cost;
        }
    }
    return ret;
}