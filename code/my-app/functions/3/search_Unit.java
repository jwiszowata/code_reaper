public PathNode search(Location start, GoalDecider gd, CostDecider cd, int maxTurns, Unit carrier) {
    return (start == null) ? null : getGame().getMap().search(this, start, gd, cd, maxTurns, carrier, null);
}