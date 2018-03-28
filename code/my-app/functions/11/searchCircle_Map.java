public Tile searchCircle(final Tile start, final GoalDecider goalDecider, final int radius) {
    if (start == null || goalDecider == null || radius <= 0)
        return null;
    for (Tile t : getCircleTiles(start, true, radius)) {
        PathNode path = new PathNode(t, 0, start.getDistanceTo(t), false, null, null);
        if (goalDecider.check(null, path) && !goalDecider.hasSubGoals())
            break;
    }
    PathNode best = goalDecider.getGoal();
    return (best == null) ? null : best.getTile();
}